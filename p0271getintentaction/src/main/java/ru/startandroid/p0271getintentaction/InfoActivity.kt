package ru.startandroid.p0271getintentaction

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class InfoActivity : AppCompatActivity() {
    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        //Получаем Intent, который вызвал этот Activity
        val intent = intent

        //читаем из него action
        val action = intent.action

        var format = ""
        var textInfo = ""

        //в зависимости от action заполянем переменные
        when(action) {
            SHOW_TIME_ACTION -> {
                format = "HH:mm:ss"
                textInfo = "Time: "
            }

            SHOW_DATE_ACTION -> {
                format = "dd.MM.yyyy"
                textInfo = "Date: "
            }
        }

        /*
            В зависимости от содержимого переменной format получаем дату или время в
                переменную datetime
         */

        val simpleDateFormat = SimpleDateFormat(format)
        val dateTime = simpleDateFormat.format(System.currentTimeMillis())

        //получаем наш TextView и сетаем туда дату или время
        val textViewForInfoActivity = findViewById<TextView>(R.id.tvInfo)
        textViewForInfoActivity.text = textInfo + dateTime
    }
}