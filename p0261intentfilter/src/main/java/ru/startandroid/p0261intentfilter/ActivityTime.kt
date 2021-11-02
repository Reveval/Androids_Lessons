package ru.startandroid.p0261intentfilter

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class ActivityTime : AppCompatActivity() {
    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time)

        //Вычисляем текущее время
        val simpleDateFormat = SimpleDateFormat("HH:mm:ss")
        val currentTime = simpleDateFormat.format(Date(System.currentTimeMillis()))

        //Получаем TextView и сетаем в него время
        val textView = findViewById<TextView>(R.id.tvTime)
        textView.text = currentTime
    }
}