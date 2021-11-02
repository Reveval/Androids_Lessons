package ru.startandroid.p0301activityresult

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

const val REQUEST_CODE_COLOR = 1
const val REQUEST_CODE_ALIGNMENT = 2

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var textViewHello: TextView
    lateinit var buttonColor: Button
    lateinit var buttonAlignment: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewHello = findViewById(R.id.text_view_hello)
        buttonColor = findViewById(R.id.button_color)
        buttonAlignment = findViewById(R.id.button_alignment)

        buttonColor.setOnClickListener(this)
        buttonAlignment.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent: Intent
        when(v?.id) {
            R.id.button_color -> {
                intent = Intent(this, ColorActivity::class.java)
                startActivityForResult(intent, REQUEST_CODE_COLOR)
            }

            R.id.button_alignment -> {
                intent = Intent(this, AlignActivity::class.java)
                startActivityForResult(intent, REQUEST_CODE_ALIGNMENT)
            }
        }
    }

    @SuppressLint("RtlHardcoded")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("myLogs", "requestCode=$requestCode, resultCode=$resultCode")
        if (resultCode == RESULT_OK && data != null) {
            when(requestCode) {
                REQUEST_CODE_COLOR -> {
                    val color = data.getIntExtra(COLOR, Color.WHITE)
                    textViewHello.setTextColor(color)
                }

                REQUEST_CODE_ALIGNMENT -> {
                    val align = data.getIntExtra(ALIGNMENT, Gravity.LEFT)
                    textViewHello.gravity = align
                }
            }
        } else {
            Toast.makeText(this, "Wrong Result", Toast.LENGTH_SHORT).show()
        }
    }
}