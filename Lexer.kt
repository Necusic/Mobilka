package com.example.blockgraming12

import java.lang.StringBuilder
import java.util.ArrayList

/**
 *
 * @author aNNiMON
 */
class Lexer(private val input: String) {
    private val length: Int
    private val tokens: MutableList<Token>
    private var pos = 0
    fun tokenize(): List<Token> {
        while (pos < length) {
            val current = peek(0)
            if (Character.isDigit(current)) tokenizeNumber() else if (current == '#') {
                next()
                tokenizeHexNumber()
            } else if (OPERATOR_CHARS.indexOf(current) != -1) {
                tokenizeOperator()
            } else {
                // whitespaces
                next()
            }
        }
        return tokens
    }

    private fun tokenizeNumber() {
        val buffer = StringBuilder()
        var current = peek(0)
        while (Character.isDigit(current)) {
            buffer.append(current)
            current = next()
        }
        addToken(TokenType.NUMBER, buffer.toString())
    }

    private fun tokenizeHexNumber() {
        val buffer = StringBuilder()
        var current = peek(0)
        while (Character.isDigit(current) || isHexNumber(current)) {
            buffer.append(current)
            current = next()
        }
        addToken(TokenType.HEX_NUMBER, buffer.toString())
    }

    private fun tokenizeOperator() {
        val position = OPERATOR_CHARS.indexOf(peek(0))
        addToken(OPERATOR_TOKENS[position])
        next()
    }

    private operator fun next(): Char {
        pos++
        return peek(0)
    }

    private fun peek(relativePosition: Int): Char {
        val position = pos + relativePosition
        return if (position >= length) '\u0000' else input[position]
    }

    private fun addToken(type: TokenType, text: String = "") {
        tokens.add(Token(type, text))
    }

    companion object {
        private const val OPERATOR_CHARS = "+-*/()"
        private val OPERATOR_TOKENS = arrayOf(
            TokenType.PLUS, TokenType.MINUS,
            TokenType.STAR, TokenType.SLASH,
            TokenType.LPAREN, TokenType.RPAREN
        )

        private fun isHexNumber(current: Char): Boolean {
            return "abcdef".indexOf(Character.toLowerCase(current)) != -1
        }
    }

    init {
        length = input.length
        tokens = ArrayList()
    }
}