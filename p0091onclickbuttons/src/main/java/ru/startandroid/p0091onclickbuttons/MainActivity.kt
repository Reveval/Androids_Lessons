package ru.startandroid.p0091onclickbuttons

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var tvOut: TextView
    lateinit var btnOk: Button
    lateinit var btnCancel: Button


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //найдем View-элементы
        tvOut = findViewById(R.id.tvOut)
        btnOk = findViewById(R.id.btnOk)
        btnCancel = findViewById(R.id.btnCancel)

        //Вешаем обработчик нажатия на кнопку Ok
        btnOk.setOnClickListener {
            tvOut.text = "Нажата кнопка OK"
        }


        //Вешаем обработчик нажатия на кнопку Cancel
        btnCancel.setOnClickListener {
            tvOut.text = "Нажата кнопка Cancel"
        }
    }
}