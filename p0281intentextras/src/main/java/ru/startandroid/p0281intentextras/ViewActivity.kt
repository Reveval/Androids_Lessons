package ru.startandroid.p0281intentextras

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ViewActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        val textView = findViewById<TextView>(R.id.tvView)

        //Получаем intent, который вызвал этот Activity
        val intent = intent

        //Извлекаем из него String-объекты, которые положили в intent методом putExtra()
        val firstName = intent.getStringExtra(FIRST_NAME)
        val lastName = intent.getStringExtra(LAST_NAME)

        //сетаем полученные данные в textView
        textView.text = "Your name is: $firstName $lastName"
    }
}