package ru.startandroid.p0191simplecalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

//в качестве обработчика - сам Activity
class MainActivity : AppCompatActivity(), View.OnClickListener {
    //Создаем переменные класса
    lateinit var editText1: EditText
    lateinit var editText2: EditText
    lateinit var buttonPlus: Button
    lateinit var buttonMinus: Button
    lateinit var buttonMultiply: Button
    lateinit var buttonDivide: Button
    lateinit var textView: TextView
    //Добавляем константы ID пунктов меню
    val MENU_RESET_ID = 1
    val MENU_QUIT = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Получаем View-элементы
        editText1 = findViewById(R.id.etNum1)
        editText2 = findViewById(R.id.etNum2)
        buttonPlus = findViewById(R.id.btnAdd)
        buttonMinus = findViewById(R.id.btnSub)
        buttonMultiply = findViewById(R.id.btnMult)
        buttonDivide = findViewById(R.id.btnDiv)
        textView = findViewById(R.id.tvResult)

        //прописываем обработчики каждой кнопке
        buttonPlus.setOnClickListener(this)
        buttonMinus.setOnClickListener(this)
        buttonMultiply.setOnClickListener(this)
        buttonDivide.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        var result = 0F
        var typeOfOperation = ""
        val messageForEmptyField = "Сначала введите число в поле"
        val ifSecondNumberIsZero = "Не корректная операция"

        //Проверим поля ввода чисел на пустоту и выведем соответствующее сообщение
        if (TextUtils.isEmpty(editText1.text) ||
                TextUtils.isEmpty(editText2.text)) {
            Toast.makeText(this, messageForEmptyField, Toast.LENGTH_LONG).show()
            return
        }

        //читаем EditText и заполняем переменные числами
        val firstNumber = editText1.text.toString().toFloat()
        val secondNumber = editText2.text.toString().toFloat()

        /*
            По нажатой кнопке определяем операцию и проводим ее с числами, в переменную
                typeOfOperation записываем тип операции для последующего вывода.
         */

        when(v?.id) {
            R.id.btnAdd -> {
                typeOfOperation = "+"
                result = firstNumber + secondNumber
            }

            R.id.btnSub -> {
                typeOfOperation = "-"
                result = firstNumber - secondNumber
            }

            R.id.btnMult -> {
                typeOfOperation = "*"
                result = firstNumber * secondNumber
            }

            R.id.btnDiv -> {
                if (secondNumber == 0F) {
                    Toast.makeText(this, ifSecondNumberIsZero, Toast.LENGTH_LONG).show()
                    return
                }
                typeOfOperation = "/"
                result = firstNumber / secondNumber
            }
        }

        //Формируем строку вывода
        textView.text = "$firstNumber $typeOfOperation $secondNumber = $result"
    }

    //пишем код для меню с кнопками очистки полей и выхода из приложения
    //создаем меню
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if (menu != null) {
            menu.add(0, MENU_RESET_ID, 0, "Reset")
            menu.add(0, MENU_QUIT, 0, "Quit")
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            //очищаем поля
            MENU_RESET_ID -> {
                editText1.setText("")
                editText2.setText("")
                textView.text = ""
            }
            //выходим из приложения
            MENU_QUIT -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}