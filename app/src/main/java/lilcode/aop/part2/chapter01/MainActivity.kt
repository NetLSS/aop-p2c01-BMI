package lilcode.aop.part2.chapter01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

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
    }
}