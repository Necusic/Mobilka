package com.example.blockgraming16



class UnaryExpression(private val operation: Char, private val expr1: Expression) : Expression {
    override fun eval(): Double {
        return when (operation) {
            '-' -> -expr1.eval()
            '+' -> expr1.eval()
            else -> expr1.eval()
        }
    }

    override fun toString(): String {
        return String.format("%c %s", operation, expr1)
    }
}