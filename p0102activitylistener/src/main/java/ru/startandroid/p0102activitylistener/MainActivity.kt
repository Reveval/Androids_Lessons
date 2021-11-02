package ru.startandroid.p0102activitylistener

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

/*
    Реализуем интерфейс View.OnClickListener, тем самым наш MainActivity будет выступать в роли
        обработчика событий
 */

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var tvOut: TextView
    lateinit var btnOk: Button
    lateinit var btnCancel: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //найдем View-элементы
        tvOut = findViewById(R.id.tvOut)
        btnOk = findViewById(R.id.btnOk)
        btnCancel = findViewById(R.id.btnCancel)

        //Присваиваем кнопкам обработчик - т.е. наш MainActivity
        btnOk.setOnClickListener(this)
        btnCancel.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.btnOk -> tvOut.text = "Нажата кнопка OK"
                R.id.btnCancel -> tvOut.text = "Нажата кнопка Cancel"
            }
        }
    }

    /*
        Мы можем написать отдельный метод и повесить на него обработку события, которое в свою
            очередь будет добавлено к кнопке при помощи xml-атрибута android:onClick
     */

    @SuppressLint("SetTextI18n")
    fun onClickStart(view: View) {
        tvOut.text = "Нажата кнопка MyButton"
    }
}