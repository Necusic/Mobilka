package com.example.blockgraming19

import java.io.File
import kotlin.jvm.JvmStatic

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        val input = String(File("C:\\Users\\User\\AndroidStudioProjects\\BlockGraming19\\app\\src\\main\\java\\com\\example\\blockgraming19\\program.txt").readBytes())
        val tokens = Lexer(input).tokenize()
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
    }
}