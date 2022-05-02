package com.example.blockgraming16

 object Variables {
    val variables= mutableMapOf<String,Double>(
        "pi" to Math.PI,
        "E" to Math.E,
    )
    fun isExists(key: String): Boolean {
        return variables.containsKey(key)

    }

    operator fun get(key: String): Double {
        return if (!isExists(key)) 0.0 else variables[key]!!
    }

     operator fun set(key: String?, value: Double) {
         Variables.variables[key!!] = value
     }


}