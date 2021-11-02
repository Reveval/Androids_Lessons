package ru.startandroid.p0161dynamiclayout

import android.annotation.SuppressLint
import android.app.ActionBar.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("RtlHardcoded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Реализуем програмным способом создание экрана
        //Создаем LinearLayout
        val linearLayout = LinearLayout(this)

        //Установим вертикальную ориентацию
        linearLayout.orientation = LinearLayout.VERTICAL

        //Устанавливаем параметры width и height для нашего LinearLayout
        val linearLayoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)

        //Устанавливаем LinearLayout как корневой параметр экрана
        setContentView(linearLayout, linearLayoutParams)

        //Добавим в наш LinearLayout несколько View-элементов

        /*
            Для начала создадим инстанс LayoutParams для всех вложенных в наш LinearLayout
                View-элементов, в котором зададим параметры ширины и высоты
                элементов согласно их содержимому
         */

        /*
            ViewGroup.LayoutParams - родитель всех LayoutParams. Он привносит два метода:
                - height
                - width

            От него наследуется ViewGroup.MarginLayoutParams, который привносит еще 4 метода:
                - bottomMargin
                - leftMargin
                - rightMargin
                - topMargin
         */

        val paramsForNestedViews = ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)

        //Создаем объект View-элемента TextView, зададим ему параметры и добавим в наш LinearLayout
        val simpleTextView = TextView(this)
        //Записываем туда некий заготовленный текст
        simpleTextView.text = getString(R.string.simple_text_view)
        //устанавливаем параметры ранее заданных высоты и ширины
        simpleTextView.layoutParams = paramsForNestedViews
        //Добавляем этот элемент в наш LinearLayout
        linearLayout.addView(simpleTextView)

        //Создаем объект View-элемента Button, зададим ему параметры и добавим в наш LinearLayout
        val firstButton = Button(this)
        //Записываем туда некий заготовленный текст
        firstButton.text = getString(R.string.first_button_text)
        //Добавляем этот элемент в наш LinearLayout и одновременно присваеваем ему параметры
        linearLayout.addView(firstButton, paramsForNestedViews)

        /*
            Теперь создадим несколько View-элементов с расширенными параметрами.
            Чтобы задействовать расширенные параметры, используем LinearLayout.LayoutParams.

            LinearLayout.LayoutParams - вложенный класс, наследник ViewGroup.MarginLayoutParams,
                к 6 методам базовых классов привносит еще 2 метода:
                - gravity
                - weight
         */

        val leftMarginParams = LinearLayout.LayoutParams(
            LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)

        //Устанавливаем отступ слева
        leftMarginParams.leftMargin = 50 //это отступ в px

        //Создаем новую кнопку
        val secondButton = Button(this)

        //Устанавливаем на ней текст
        secondButton.text = getString(R.string.second_button_text)

        //Добавляем кнопку на наш LinearLayout и задаем ей параметры согласно leftMarginParams
        linearLayout.addView(secondButton, leftMarginParams)

        //Аналогично примеру выше создаем кнопку, к которой будет применено выравнивание
        val rightGravityParams = LinearLayout.LayoutParams(
            LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        rightGravityParams.gravity = Gravity.RIGHT
        val thirdButton = Button(this)
        thirdButton.text = getString(R.string.third_button_text)
        linearLayout.addView(thirdButton, rightGravityParams)
    }
}