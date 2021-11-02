package ru.startandroid.p0121logandmess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

//В const переменную запишем название нашего кастомного лога
private const val TAG = "myLogs"

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var textView: TextView
    lateinit var buttonOk: Button
    lateinit var buttonCancel: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //запишем сообщение о поиске элементов в дебаг-лог
        Log.d(TAG, "найдем View-элементы")
        textView = findViewById(R.id.tvOut)
        buttonOk = findViewById(R.id.btnOk)
        buttonCancel = findViewById(R.id.btnCancel)

        //запишем сообщение о присвоении кнопкам listener
        Log.d(TAG, "присваиваем обработчик кнопкам")
        buttonOk.setOnClickListener(this)
        buttonCancel.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        //запишем в дебаг-лог сообщение о каждом этапе работы listener
        if (v != null) {
            Log.d(TAG, "по id определяем кнопку, вызвавшую этот обработчик")
            when(v.id) {
                R.id.btnOk -> {
                    Log.d(TAG, "кнопка ОК")
                    textView.text = resources.getString(R.string.ok_pressed)
                    //Создаем всплывающее сообщение при помощи View-элемента Toast
                    Toast.makeText(this, "Нажата кнопка ОК", Toast.LENGTH_LONG).show()
                }
                R.id.btnCancel -> {
                    Log.d(TAG, "кнопка Cancel")
                    textView.text = resources.getString(R.string.cancel_pressed)
                    //Создаем всплывающее сообщение при помощи View-элемента Toast
                    Toast.makeText(this, "Нажата кнопка Cancel", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}