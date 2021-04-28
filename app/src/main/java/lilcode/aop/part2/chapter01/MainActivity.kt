package lilcode.aop.part2.chapter01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // R.layout.activity_main 레이아웃을 가져와서 컨텐츠 뷰로 설정
        // R: 리소스
        setContentView(R.layout.activity_main)

        val heightEditText: EditText  = findViewById(R.id.heightEditText)
        //val weightEditText = findViewById(R.id.weightEditText) // 반환 값이 정확이 뭔지 알 수 없다
        val weightEditText = findViewById<EditText>(R.id.weightEditText) //<>에 반환 값이 뭔지 알려줌

        val resultButton = findViewById<Button>(R.id.resultButton)

        resultButton.setOnClickListener {
            // 로그 남기기
            Log.d("MainActivity", "ResultButton 이 클릭되었습니다.")

            // 빈 값이 들어오는 경우 예외처리
            if (heightEditText.text.isEmpty() || weightEditText.text.isEmpty()){
                Toast.makeText(this, "빈 값이 있습니다.", Toast.LENGTH_SHORT).show()

                return@setOnClickListener // setOnClickListener 라는 함수의 return 임을 명시
            }

            val height: Int = heightEditText.text.toString().toInt()
            val weight: Int = weightEditText.text.toString().toInt()

            Log.d("MainActivity", "height: $height, weight: $weight")

            // MainActivity 에서 ResultActivity 로 넘어가기
            val intent = Intent(this, ResultActivity::class.java /*클래스 이름*/)
            startActivity(intent)
        }
    }
}