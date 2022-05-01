package com.example.blockgraming16

import com.example.blockgraming16.Constants.isExists


class ConstantExpression(private val name: String) : Expression {
    override fun eval(): Double {
        if (!isExists(name)) throw RuntimeException("Constant does not exists")
        return Constants[name]
    }

    override fun toString(): String {
//        return String.format("%s [%f]", name, Constants.get(name));
        return String.format("%s", name)
    }
}