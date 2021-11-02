package ru.startandroid.p0081viewbyid

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Получаем програмно при помощи id view объект типа TextView
        val myTextView: TextView = findViewById(R.id.myText)

        //Програмно изменяем текст
        myTextView.text = "New Text in TextView"

        //Получаем програмно при помощи id view объект типа Button
        val myBtn: Button = findViewById(R.id.myBtn)

        //Изменим текст кнопки
        myBtn.text = "My button"

        //Сделаем кнопку неактивной
        myBtn.isEnabled = false

        //Получаем програмно при помощи id view объект типа Checkbox
        val myChb: CheckBox = findViewById(R.id.myChb)

        //Поставим програмно галочку на checkbox
        myChb.isChecked = true
    }
}