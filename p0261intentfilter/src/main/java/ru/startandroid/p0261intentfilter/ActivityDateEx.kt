package ru.startandroid.p0261intentfilter

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class ActivityDateEx : AppCompatActivity() {
    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)

        //Устанавливаем формат отображения даты и получаем текущую дату согласно формату
        val otherDateFormat = SimpleDateFormat("EEE, MMM d, yyyy")
        val currentDateInOtherFormat = otherDateFormat.format(Date(System.currentTimeMillis()))

        //получаем TextView и сетаем в него дату
        val textViewDate = findViewById<TextView>(R.id.tvDate)
        textViewDate.text = currentDateInOtherFormat
    }
}