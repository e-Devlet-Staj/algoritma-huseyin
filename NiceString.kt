package com.example.nicestring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var mCnt=0
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            mCnt=0
            var given=editTextText.text.toString()
            if(subChecker(given))
                mCnt++
            if(vowChecker(given))
                mCnt++
            if(doubleChecker(given))
                mCnt++
            Log.e("Log",""+mCnt)
            if(mCnt>=2)
            text.setText("It's a nice String")
            else
            text.setText("It's not a nice string")
        }
    }

    fun subChecker(given: String): Boolean {
        for (i in 0 until given.length-1) {
            if (given[i] == 'b')
                if (given[i + 1] == 'u' || given[i + 1] == 'a' || given[i + 1] == 'e')
                    return false
        }
        Log.e("Log","sC")
        return true

    }
    fun vowChecker(given: String): Boolean {
        var ch = 'x'
        var cnt = 0
        Log.e("vow",""+cnt)
        for (i in 0 until given.length) {
            ch = given[i]
            if(ch.equals('a')||ch.equals('e')||ch.equals('i')||ch.equals('o')||ch.equals('u'))
            cnt++

        }
        Log.e("cnt",""+cnt)
        if (cnt >= 3){
            Log.e("Log","vC")
            return true

        }
        return false
    }
    fun doubleChecker(given: String): Boolean{
        for (i in 0 until given.length-1) {
            if(i<given.length)
                if (given[i] == given[i+1]){
                    Log.e("Log","dC")
                    return true
                }
        }
        return false
    }
}