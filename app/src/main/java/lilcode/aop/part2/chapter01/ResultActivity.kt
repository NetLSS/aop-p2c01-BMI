package lilcode.aop.part2.chapter01

import android.os.Bundle
import android.service.autofill.TextValueSanitizer
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class ResultActivity: AppCompatActivity() {

    // Activity 실행 되었을 때 동작
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        Log.d("ResultActivity", "height: $height, weight: $weight")

        val bmi = weight / (height / 100.0).pow(2.0) // 코틀린은 double 타입이 pow 함수를 갖고 있다
        val resultText = when {
            bmi>= 35.0 -> "고도 비만"
            bmi>= 30.0 -> "중정도 비만"
            bmi>= 25.0 -> "경도 비만"
            bmi>= 23.0 -> "과체중"
            bmi>= 18.5 -> "정상체중"
            else -> "저체중"
        }

        val resultValueTextView = findViewById<TextView>(R.id.bmiResultTextView)
        val resultStringTextView = findViewById<TextView>(R.id.resultTextView)

        resultValueTextView.text = bmi.toString()
        resultStringTextView.text = resultText
    }
}