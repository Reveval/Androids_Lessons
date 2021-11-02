package ru.startandroid.p0331sharedpreferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.edit

const val SAVED_TEXT = "saved_text"

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var editSomeText: EditText
    lateinit var buttonSave: Button
    lateinit var buttonLoad: Button
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editSomeText = findViewById(R.id.edit_some_text)
        buttonSave = findViewById(R.id.button_save)
        buttonLoad = findViewById(R.id.button_load)

        buttonSave.setOnClickListener(this)
        buttonLoad.setOnClickListener(this)

        //текст будет загружаться при открытии приложения
        loadText()
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.button_save -> saveText()
            R.id.button_load -> loadText()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        //текст будет сохранятся при закрытии приложения
        saveText()
    }

    private fun saveText() {
        /*
            получаем объект SharedPreferences, который позволяет работать с данными.
                под капотом вызывается метод getSharedPreferences, который формирует файл с
                preference-данными на диске и называет его по имени текущего Activity.
                
         */
        sharedPreferences = getPreferences(MODE_PRIVATE)
        /*
            чтобы редактировать данные, необходим объект Editor, получаем его из sharedPreferences.
            метод putString принимает наименование переменной и значение - содержимое поля
            editSomeText.
            Чтобы данные сохранились, необходимо выполнить commit()

         */
        sharedPreferences.edit {
            putString(SAVED_TEXT, editSomeText.text.toString())
            commit()
        }
        Toast.makeText(this, "Text Saved", Toast.LENGTH_SHORT).show()
    }

    private fun loadText() {
        sharedPreferences = getPreferences(MODE_PRIVATE)
        /*
            чтение текста осуществляем методом getString() - необходимо указать наименование и
            значение
         */
        val savedText = sharedPreferences.getString(SAVED_TEXT, "")
        editSomeText.setText(savedText)
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show()
    }
}