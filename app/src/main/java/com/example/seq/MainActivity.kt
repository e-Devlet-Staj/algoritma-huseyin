package com.example.seq

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Switch
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var prediction = ""
        var txtCnt = 0
        var randomizedChars = randomizer()

        button.setOnClickListener {
            var positions = 0
            var letters = 0
            var new = CharArray(4)
            prediction = editText.text.toString()

            for (i in 0 until 4) {
                new[i] = prediction[i]
            }
            posChecker(new, randomizedChars)
            Log.e("Prediction", "" + new.joinToString(" "))
            Log.e(
                "Computer",
                "" + randomizedChars[0] + " " + randomizedChars[1] + " " + randomizedChars[2] + " " + randomizedChars[3]
            )
            Log.e("mtvc", "" + moreThanOneFinder(new))
            positions = posChecker(new, randomizedChars)
            letters = letChecker(new, randomizedChars)
            textView13.setText("" + positions)
            textView15.setText("" + letters)
            textWriter(txtCnt, prediction)
            txtCnt++
            if (txtCnt == 9 && positions != 4) {
                for (i in 0 until 10)
                    textWriter(i, "OYUN BITTI")
            } else if (positions == 4) {
                for (i in 0 until 10)
                    textWriter(i, "TEBRİKLER")
            textView15.setText("")
            }
        }
        editText.setOnClickListener() {
            editText.setText("")
        }

    }

    fun randomizer(): CharArray {
        var res = 0
        var rand = CharArray(4)
        for (i in 0 until 4) {
            res = Random.nextInt(0, 6)
            if (res == 0)
                rand[i] = 'A'
            else if (res == 1)
                rand[i] = 'B'
            else if (res == 2)
                rand[i] = 'C'
            else if (res == 3)
                rand[i] = 'D'
            else if (res == 4)
                rand[i] = 'E'
            else if (res == 5)
                rand[i] = 'F'
        }

        return rand

    }

    fun posChecker(prediction: CharArray, randomizedChars: CharArray): Int {
        var cnt = 0
        for (i in 0 until 4) {
            if (prediction[i] == randomizedChars[i])
                cnt++
        }
        return cnt
    }

    fun letChecker(prediction: CharArray, randomizedChars: CharArray): Int {
        var cnt = 0
        var init = false
        for (i in 0 until 4)
            for (j in 0 until 4) {
                if (init)
                    if (prediction[i] == randomizedChars[j]) {
                        cnt++

                    }
                if (!prediction[i].equals(moreThanOneFinder(prediction)) && prediction[i] == randomizedChars[j])
                    cnt++
            }
        return cnt

    }

    fun textWriter(iter: Int, text: String) {
        if (iter == 0) {
            textView.setText(text)
        } else if (iter == 1) {
            textView2.setText(text)
        } else if (iter == 2) {
            textView3.setText(text)
        } else if (iter == 3) {
            textView4.setText(text)
        } else if (iter == 4) {
            textView5.setText(text)
        } else if (iter == 5) {
            textView6.setText(text)
        } else if (iter == 6) {
            textView7.setText(text)
        } else if (iter == 7) {
            textView8.setText(text)
        } else if (iter == 8) {
            textView9.setText(text)
        } else if (iter == 9) {
            textView10.setText(text)
        }
    }

    fun moreThanOneFinder(cA: CharArray): Char {
        for (i in 0 until 4) {
            for (j in i + 1 until 4) {
                if (cA[i].equals(cA[j]))
                    return cA[i]
            }
        }
        return 'X'
    }

}

