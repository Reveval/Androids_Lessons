package ru.startandroid.p0301activityresult

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button

const val ALIGNMENT = "alignment"

class AlignActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var buttonLeft: Button
    lateinit var buttonCenter: Button
    lateinit var buttonRight: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_align)

        buttonLeft = findViewById(R.id.button_left)
        buttonCenter = findViewById(R.id.button_center)
        buttonRight = findViewById(R.id.button_right)

        buttonLeft.setOnClickListener(this)
        buttonCenter.setOnClickListener(this)
        buttonRight.setOnClickListener(this)
    }

    @SuppressLint("RtlHardcoded")
    override fun onClick(v: View?) {
        val intent = Intent()
        when(v?.id) {
            R.id.button_left -> intent.putExtra(ALIGNMENT, Gravity.LEFT)
            R.id.button_center -> intent.putExtra(ALIGNMENT, Gravity.CENTER)
            R.id.button_right -> intent.putExtra(ALIGNMENT, Gravity.RIGHT)
        }
        setResult(RESULT_OK, intent)
        finish()
    }
}