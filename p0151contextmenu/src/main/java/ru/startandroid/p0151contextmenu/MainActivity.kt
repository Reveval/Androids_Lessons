package ru.startandroid.p0151contextmenu

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import ru.startandroid.p0151contextmenu.utils.*

class MainActivity : AppCompatActivity() {
    lateinit var textViewColor: TextView
    lateinit var textViewSize: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Находим View-элементы
        textViewColor = findViewById(R.id.tvColor)
        textViewSize = findViewById(R.id.tvSize)

        /*
            При помощи метода ниже задаем элементы View, для которых необходимо
                создавать контекстное меню
         */

        registerForContextMenu(textViewColor)
        registerForContextMenu(textViewSize)
    }

    //реализованный ниже метод позволяет програмно создать контекстное меню
    /*override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        when(v?.id) {
            R.id.tvColor -> {
                menu?.add(0, Constants.MENU_COLOR_RED, 0, Constants.COLOR_RED)
                menu?.add(0, Constants.MENU_COLOR_GREEN, 0, Constants.COLOR_GREEN)
                menu?.add(0, Constants.MENU_COLOR_BLUE, 0, Constants.COLOR_BLUE)
            }

            R.id.tvSize -> {
                menu?.add(0, Constants.MENU_SIZE_22, 0, Constants.SIZE_22)
                menu?.add(0, Constants.MENU_SIZE_26, 0, Constants.SIZE_26)
                menu?.add(0, Constants.MENU_SIZE_30, 0, Constants.SIZE_30)
            }
        }
        super.onCreateContextMenu(menu, v, menuInfo)
    }*/

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        when(v?.id) {
            R.id.tvColor -> menuInflater.inflate(R.menu.my_context_menu_colors, menu)
            R.id.tvSize -> menuInflater.inflate(R.menu.my_context_menu_sizes, menu)
        }
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    @SuppressLint("SetTextI18n")
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.red_color -> {
                textViewColor.setTextColor(Color.RED)
                textViewColor.text = "Text color = red"
            }

            R.id.green_color -> {
                textViewColor.setTextColor(Color.GREEN)
                textViewColor.text = "Text color = green"
            }

            R.id.blue_color -> {
                textViewColor.setTextColor(Color.BLUE)
                textViewColor.text = "Text color = blue"
            }

            R.id.twenty_two_size -> {
                textViewSize.textSize = 22F
                textViewSize.text = "Text size = 22"
            }

            R.id.twenty_six_size -> {
                textViewSize.textSize = 26F
                textViewSize.text = "Text size = 26"
            }

            R.id.thirty_size -> {
                textViewSize.textSize = 30F
                textViewSize.text = "Text size = 30"
            }
        }

        return super.onContextItemSelected(item)
    }
}