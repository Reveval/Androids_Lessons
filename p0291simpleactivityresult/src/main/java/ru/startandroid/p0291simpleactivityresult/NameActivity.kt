package ru.startandroid.p0291simpleactivityresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class NameActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var editTextName: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        //Получаем View и вешаем обработчик
        editTextName = findViewById(R.id.etName)
        val buttonOK = findViewById<Button>(R.id.btnOK)
        buttonOK.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent()
        intent.putExtra(NAME, editTextName.text.toString())
        setResult(RESULT_OK, intent)
        finish()
    }
}