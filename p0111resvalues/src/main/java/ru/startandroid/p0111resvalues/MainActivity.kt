package ru.startandroid.p0111resvalues

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Програмно изменим некоторые View-элементы
        //Для начала получим эти элементы
        val llBottom: LinearLayout = findViewById(R.id.llBottom)
        val tvBottom: TextView = findViewById(R.id.tvBottom)
        val btnBottom: Button = findViewById(R.id.btnBottom)

        //Устанавливаем LinearLayout цвет background
        llBottom.setBackgroundColor(R.color.llBottomColor)

        //Заменяем текст на элементе TextView
        tvBottom.setText(R.string.tvBottomText)

        //заменяем текст на кнопке
        btnBottom.setText(R.string.btnBottomText)

        //как получить значение ресурса
        val value = resources.getString(R.string.tvBottomText)
    }
}