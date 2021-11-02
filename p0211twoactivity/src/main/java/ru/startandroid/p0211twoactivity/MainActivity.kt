package ru.startandroid.p0211twoactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var buttonForSecondActivity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Получаем кнопку и вешаем на нее обработчик нажатия
        buttonForSecondActivity = findViewById(R.id.btnActTwo)
        buttonForSecondActivity.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btnActTwo -> {
                val intent = Intent(this, ActivityTwo::class.java)
                startActivity(intent)
            }
            else -> {}
        }
    }
}