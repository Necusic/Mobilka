package com.example.blockgraming12





class Parser(private val tokens: List<Token>) {
    private val size: Int
    private var pos = 0
    fun parse(): List<Expression> {
        val result: MutableList<Expression> = ArrayList()
        while (!match(TokenType.EOF)) {
            result.add(expression())
        }
        return result
    }

    private fun expression(): Expression {
        return additive()
    }

    private fun additive(): Expression {
        var result = multiplicative()
        while (true) {
            if (match(TokenType.PLUS)) {
                result = BinaryExpression('+', result, multiplicative())
                continue
            }
            if (match(TokenType.MINUS)) {
                result = BinaryExpression('-', result, multiplicative())
                continue
            }
            break
        }
        return result
    }

    private fun multiplicative(): Expression {
        var result = unary()
        while (true) {

            if (match(TokenType.STAR)) {
                result = BinaryExpression('*', result, unary())
                continue
            }
            if (match(TokenType.SLASH)) {
                result = BinaryExpression('/', result, unary())
                continue
            }
            break
        }
        return result
    }

    private fun unary(): Expression {
        if (match(TokenType.MINUS)) {
            return UnaryExpression('-', primary())
        }
        return if (match(TokenType.PLUS)) {
            primary()
        } else primary()
    }

    private fun primary(): Expression {
        val current = get(0)
        if (match(TokenType.NUMBER)) {
            return NumberExpression(current.text!!.toDouble())
        }
        if (match(TokenType.HEX_NUMBER)) {
            return NumberExpression(current.text!!.toLong(16).toDouble())
        }
        if (match(TokenType.LPAREN)) {
            val result = expression()
            match(TokenType.RPAREN)
            return result
        }
        throw RuntimeException("Unknown expression")
    }

    private fun match(type: TokenType): Boolean {
        val current = get(0)
        if (type !== current.type) return false
        pos++
        return true
    }

    private operator fun get(relativePosition: Int): Token {
        val position = pos + relativePosition
        return if (position >= size) EOF else tokens[position]
    }

    companion object {
        private val EOF = Token(TokenType.EOF, "")
    }

    init {
        size = tokens.size
    }
}