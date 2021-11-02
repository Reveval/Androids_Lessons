package ru.startandroid.p0101listener

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

        //находим view-элементы
        tvOut = findViewById(R.id.tvOut)
        btnOk = findViewById(R.id.btnOk)
        btnCancel = findViewById(R.id.btnCancel)

        //Создадим обработчик, на котором будет висеть 2 действия
        val oclBtn = View.OnClickListener {
            when(it.id) {
                R.id.btnOk -> tvOut.text = "Нажата кнопка Ok"
                R.id.btnCancel -> tvOut.text = "Нажата кнопка Cancel"
            }
        }

        //Вешаем на обе кнопки один и тот же обработчик
        btnOk.setOnClickListener(oclBtn)
        btnCancel.setOnClickListener(oclBtn)
    }
}