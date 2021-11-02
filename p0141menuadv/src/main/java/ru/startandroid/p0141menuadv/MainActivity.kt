package ru.startandroid.p0141menuadv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //Создаем переменные для последующего использвоания
    lateinit var textView: TextView
    lateinit var checkBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Находим элементы View по их ID
        textView = findViewById(R.id.textView)
        checkBox = findViewById(R.id.chbExtMenu)
    }

    //Создаем пункты меню - образец ручного создания
    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(0, 1, 0, "add")
        menu?.add(0, 2, 0, "edit")
        menu?.add(0, 3, 3, "delete")
        menu?.add(1, 4, 1, "copy")
        menu?.add(1, 5, 2, "paste")
        menu?.add(1, 6, 4, "exit")
        return super.onCreateOptionsMenu(menu)
    }*/

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mymenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //Обновление пунктов меню
    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        //пункты меню с ID группы = 1 видны, если в CheckBox стоит галка
        menu?.setGroupVisible(R.id.group1, checkBox.isChecked)
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Toast.makeText(this, item.title, Toast.LENGTH_LONG).show()
        val message = """Item Menu
        groupID: ${item.groupId}
        itemId: ${item.itemId}
        order: ${item.order}
        title: ${item.title}"""
        textView.text = message
        return super.onOptionsItemSelected(item)
    }
}