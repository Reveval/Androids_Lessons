package ru.startandroid.p0241twoactivitystate

import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

const val TAG = "States"

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var firstButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Получаем кнопку
        firstButton = findViewById(R.id.btnActTwo)
        //Вешаем на кнопку обработчик нажатий
        firstButton.setOnClickListener(this)
        //Записываем в логи информацию для демонстрации работы метода
        Log.d(TAG, "MainActivity: onCreate()")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "MainActivity: onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "MainActivity: onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "MainActivity: onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "MainActivity: onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "MainActivity: onDestroy()")
    }

    //по нажатию на кнопку переключаемся на ActivityTwo
    override fun onClick(v: View?) {
        val intent = Intent(this, ActivityTwo::class.java)
        startActivity(intent)
    }
}