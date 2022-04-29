package com.example.blockgraming12
import kotlin.jvm.JvmStatic

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val input2 = "3/0"
        val tokens = Lexer(input2).tokenize()
        for (token in tokens) {
            println(token)
        }
        val expressions = Parser(tokens).parse()
        for (expr in expressions) {
            println(expr.toString() + " = " + expr.eval())
        }
    }
}