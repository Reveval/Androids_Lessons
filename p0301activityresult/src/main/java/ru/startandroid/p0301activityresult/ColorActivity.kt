package ru.startandroid.p0301activityresult

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

const val COLOR = "color"

class ColorActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var buttonRed: Button
    lateinit var buttonGreen: Button
    lateinit var buttonBlue: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color)

        buttonRed = findViewById(R.id.button_red)
        buttonGreen = findViewById(R.id.button_green)
        buttonBlue = findViewById(R.id.button_blue)

        buttonRed.setOnClickListener(this)
        buttonGreen.setOnClickListener(this)
        buttonBlue.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent =  Intent()
        when(v?.id) {
            R.id.button_red -> intent.putExtra(COLOR, Color.RED)
            R.id.button_green -> intent.putExtra(COLOR, Color.GREEN)
            R.id.button_blue -> intent.putExtra(COLOR, Color.BLUE)
        }
        setResult(RESULT_OK, intent)
        finish()
    }
}