package com.example.blockgraming16


import kotlin.jvm.JvmStatic

object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        val input1 = "2 + 2"
        //        final String input2 = "(GOLDEN_RATIO + 2) * #f";
        val input2 = "GOLDEN_RATIO"
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