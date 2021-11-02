package ru.startandroid.p0181dynamiclayout3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.SeekBar

//для того, чтобы добавить обработчик SeekBar нашему Activity, реализуем соответсвующий интерфейс
class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {
    //Объявим переменные
    lateinit var seekBar: SeekBar
    lateinit var button1: Button
    lateinit var button2: Button

    lateinit var paramsForButton1: LinearLayout.LayoutParams
    lateinit var paramsForButton2: LinearLayout.LayoutParams

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //получим доступ к View-элементам нашего LinearLayout
        seekBar = findViewById(R.id.sbWeight)

        //присваиваем SeekBar обработчик события onProgressChanged
        seekBar.setOnSeekBarChangeListener(this)

        button1 = findViewById(R.id.btn1)
        button2 = findViewById(R.id.btn2)

        /*
            используем метод getLayoutParams для получения LayoutParams наших кнопок
         */

        paramsForButton1 = button1.layoutParams as LinearLayout.LayoutParams
        paramsForButton2 = button2.layoutParams as LinearLayout.LayoutParams
    }

    //срабатывает все время, пока значение меняется
    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        //текущее значение ползунка - progress
        //то, что справа от ползунка
        if (seekBar != null) {
            val rightValue = seekBar.max.minus(progress)
            //настраиваем weight у кнопок через переменные LayoutParams
            paramsForButton1.weight = progress.toFloat()
            paramsForButton2.weight = rightValue.toFloat()
            //в текст кнопок пишем значения переменных для наглядности
            button1.text = progress.toString()
            button2.text = rightValue.toString()
        }
    }

    //этот обработчик срабатывает, когда начинаем тащить ползунок
    override fun onStartTrackingTouch(seekBar: SeekBar?) {}

    //срабатывает, когда отпускаем ползунок
    override fun onStopTrackingTouch(seekBar: SeekBar?) {}
}