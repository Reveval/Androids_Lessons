package ru.startandroid.p0281intentextras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

const val FIRST_NAME = "firstName"
const val LAST_NAME = "lastName"

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var firstNameEditText: EditText
    lateinit var lastNameEditText: EditText
    lateinit var buttonSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstNameEditText = findViewById(R.id.etFName)
        lastNameEditText = findViewById(R.id.etLName)
        buttonSubmit = findViewById(R.id.btnSubmit)

        buttonSubmit.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        val intent = Intent(this, ViewActivity::class.java)

        //добаляем к нашему intent данные
        intent.putExtra(FIRST_NAME, firstNameEditText.text.toString())
        intent.putExtra(LAST_NAME, lastNameEditText.text.toString())

        startActivity(intent)
    }
}