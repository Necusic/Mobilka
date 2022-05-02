package com.example.blockgraming16

class NumberExpression(private val value: Double) : Expression {
    override fun eval(): Double {
        return value
    }

    override fun toString(): String {
        return java.lang.Double.toString(value)
    }
}