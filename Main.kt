package com.example.blockgraming16

import kotlin.jvm.JvmStatic

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val input1 = "word = 2 + 2\nword2 = pi + word"

        val tokens = Lexer(input1).tokenize()
        for (token in tokens) {
            println(token)
        }
        val statements = Parser(tokens).parse()
        for (statement in statements) {
            println(statement)
        }
        for (statement in statements) {
            statement.execute()
        }
        System.out.printf("%s = %f\n", "word", Variables["word"])
        System.out.printf("%s = %f\n", "word2", Variables["word2"])
    }
}