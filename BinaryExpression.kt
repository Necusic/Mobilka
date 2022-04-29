package com.example.blockgraming12

class BinaryExpression(
    private val operation: Char,
    private val expr1: Expression,
    private val expr2: Expression
) : Expression {
    override fun eval(): Double {
        return when (operation) {
            '-' -> expr1.eval() - expr2.eval()
            '*' -> expr1.eval() * expr2.eval()
            '/' -> expr1.eval() / expr2.eval()
            '+' -> expr1.eval() + expr2.eval()
            else -> expr1.eval() + expr2.eval()
        }
    }

    override fun toString(): String {
        return String.format("%s %c %s", expr1, operation, expr2)
    }
}