package ru.startandroid.p0171dynamiclayout2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    //Создаем вспомогательные переменные
    lateinit var linearLayout: LinearLayout
    lateinit var radioGroup: RadioGroup
    lateinit var editText: EditText
    lateinit var buttonCreate: Button
    lateinit var buttonClear: Button


    //Создаем отдельную переменную для хранения значения WRAP_CONTENT
    private val wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT
    //Создаем отдельную переменную для хранения значения Gravity
    @SuppressLint("RtlHardcoded")
    private var gravityForButtons = Gravity.LEFT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Получим View-элементы
        linearLayout = findViewById(R.id.llMain)
        radioGroup = findViewById(R.id.rgGravity)
        editText = findViewById(R.id.etName)
        buttonCreate = findViewById(R.id.btnCreate)
        buttonClear = findViewById(R.id.btnClear)

        //Вешаем обработчик событий на кнопки
        buttonCreate.setOnClickListener(this)
        buttonClear.setOnClickListener(this)


    }

    @SuppressLint("RtlHardcoded")
    override fun onClick(v: View?) {
        when(v?.id) {
            //Создание новых кнопок
            R.id.btnCreate -> {
                //Создаем LayoutParams с шириной и высотой по содержимому
                val paramsForNewButtons = LinearLayout.LayoutParams(wrapContent, wrapContent)
                //Определяем какой из RadioButtons чекнут и соответственно заполняем gravityForButtons
                when(radioGroup.checkedRadioButtonId) { //это свойство возвращает id checked-radio
                    R.id.rbLeft -> gravityForButtons = Gravity.LEFT
                    R.id.rbCenter -> gravityForButtons = Gravity.CENTER
                    R.id.rbRight -> gravityForButtons = Gravity.RIGHT
                }

                //Полученное значение присваиваем LayoutParams.gravity
                paramsForNewButtons.gravity = gravityForButtons

                /*
                    Создаем Button, добавляем в него текст из EditText View, и добавляем кнопку в
                        LinearLayout
                 */

                val newButton = Button(this)
                newButton.text = editText.text
                linearLayout.addView(newButton, paramsForNewButtons)
            }

            //Удаление содержимого layout
            R.id.btnClear -> {
                //этот метод удаляет все компоненты из нашего layout
                linearLayout.removeAllViews()
                Toast.makeText(this, "Удалено", Toast.LENGTH_SHORT).show()
            }
        }
    }
}