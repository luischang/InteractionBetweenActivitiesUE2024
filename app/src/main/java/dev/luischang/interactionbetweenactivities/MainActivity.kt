package dev.luischang.interactionbetweenactivities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val etMessage: EditText = findViewById(R.id.etMessage)
        val btnSend: Button = findViewById(R.id.btnSend)

        btnSend.setOnClickListener {
            val intent = Intent(this,ResultActivity::class.java)
            val message: String = etMessage.text.toString()
            intent.putExtra("param",message)
            startActivity(intent)
        }
    }
}