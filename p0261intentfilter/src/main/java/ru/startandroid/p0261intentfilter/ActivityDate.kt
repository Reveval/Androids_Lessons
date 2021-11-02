package ru.startandroid.p0261intentfilter

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class ActivityDate : AppCompatActivity() {
    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)

        //Устанвливаем формат даты и создаем саму дату
        val simpleDateFormat = SimpleDateFormat("dd.MM.yyyy")
        val currentDate = simpleDateFormat.format(Date(System.currentTimeMillis()))

        //Получаем TextView и сетаем туда текущую дату
        val textViewForDate = findViewById<TextView>(R.id.tvDate)
        textViewForDate.text = currentDate
    }
}