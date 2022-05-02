package com.example.blockgraming16

import com.example.blockgraming16.Variables.set

class AssignmentStatement(private val variable: String, private val expression: Expression) :
    Statement {
    override fun execute() {
        val result = expression.eval()
        set(variable, result)
    }

    override fun toString(): String {
        return String.format("%s = %s", variable, expression)
    }
}