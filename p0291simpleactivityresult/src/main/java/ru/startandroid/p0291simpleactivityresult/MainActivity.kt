package ru.startandroid.p0291simpleactivityresult

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

const val NAME = "name"

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var nameTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Получаем наши View-элементы и вешаем на кнопку обработчик - MainActivity
        nameTextView = findViewById(R.id.tvName)
        val inputNameButton = findViewById<Button>(R.id.btnName)
        inputNameButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, NameActivity::class.java)
        startActivityForResult(intent, 1)
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (data == null) return
        val name = data.getStringExtra(NAME)
        nameTextView.text = "Your name is $name"
    }
}