package com.example.blockgraming16

import java.util.HashMap

internal object Constants {
    private val constants: MutableMap<String, Double>? = null
    fun isExists(key: String): Boolean {
        return constants!!.containsKey(key)
    }

    operator fun get(key: String): Double {
        return if (!isExists(key)) 0.0 else constants!![key]!!
    }

    init {
        val constants = HashMap()
        constants["PI"] = Math.PI
        constants["ПИ"] = Math.PI
        constants["E"] = Math.E
        constants["GOLDEN_RATIO"] = 1.618
    }
}