package com.example.blockgraming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}
class Token(val tupe:String,val vaLue:String){
    init {
        this.tupe
        this.vaLue
    }
}


class Lexrer(val code: String){
    val tokens = IntArray(0)
    init {
        this.code
        this.tokens
    }
    fun reset(){
        this.tokens[0]
        return tokens

    }
    fun addToken(tupe: String,vaLue: String){

    }

}
