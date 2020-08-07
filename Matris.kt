package com.example.matris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            var given=editText.text.toString()
            shortPathFinder(given)
        }
    }
    fun shortPathFinder(given:String){

        var new=given.split('*')
        Log.e("Log",""+new[0].toString().toInt())
        var result=0
        for (i in 2 until new[0].toString().toInt()+1) {
            result += i
        }
        for (i in 2 until new[1].toString().toInt()+1){
            result=result+new[0].toString().toInt()*i
        }
        textView.setText(""+result)
    }
}