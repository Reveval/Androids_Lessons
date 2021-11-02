package ru.startandroid.p0261intentfilter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

/*
    Инициализируем константы для будущих action - строкой константы, которая
        указывает на действие, которое мы хотим произвести
 */

const val SHOW_TIME_ACTION = "ru.startandroid.intent.action.showtime"
const val SHOW_DATE_ACTION = "ru.startandroid.intent.action.showdate"

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var intentForNewActivity: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Получаем наши кнопки и вешаем на них обрабочик
        val buttonShowTime = findViewById<Button>(R.id.btnTime)
        val buttonShowDate = findViewById<Button>(R.id.btnDate)

        buttonShowTime.setOnClickListener(this)
        buttonShowDate.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btnTime -> {
                intentForNewActivity = Intent(SHOW_TIME_ACTION)
                startActivity(intentForNewActivity)
            }

            R.id.btnDate -> {
                intentForNewActivity = Intent(SHOW_DATE_ACTION)
                startActivity(intentForNewActivity)
            }
        }
    }
}