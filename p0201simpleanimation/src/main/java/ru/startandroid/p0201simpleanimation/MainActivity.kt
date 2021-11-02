package ru.startandroid.p0201simpleanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import ru.startandroid.p0201simpleanimation.utils.enums.Constants.*

class MainActivity : AppCompatActivity() {
    //Создаем классовую переменную для TextView
    private lateinit var textView: TextView
    private lateinit var animation: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //получаем TextView
        textView = findViewById(R.id.tv)
        //регистрируем контекстное меню для TextView
        registerForContextMenu(textView)
    }

    //Создаем програмно пункты меню
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        if (menu != null) {
            menu.add(0, MENU_ALPHA.id, 0, getString(R.string.menu_alpha_title))
            menu.add(0, MENU_SCALE.id, 0, getString(R.string.menu_scale_title))
            menu.add(0, MENU_TRANSLATE.id, 0, getString(R.string.menu_translate_title))
            menu.add(0, MENU_ROTATE.id, 0, getString(R.string.menu_rotate_title))
            menu.add(0, MENU_COMBO.id, 0, getString(R.string.menu_combo_title))
        } else {
            Log.d("myLogs", "menu is null")
        }
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    //Создаем обработчик на элементы меню
    override fun onContextItemSelected(item: MenuItem): Boolean {
        //определяем, какой пункт меню был нажат и вешаем соответствующую анимацию
        when(item.itemId) {
            MENU_ALPHA.id -> animation = AnimationUtils.loadAnimation(this, R.anim.myalpha)
            MENU_SCALE.id -> animation = AnimationUtils.loadAnimation(this, R.anim.myscale)
            MENU_TRANSLATE.id -> animation = AnimationUtils.loadAnimation(this, R.anim.mytrans)
            MENU_ROTATE.id -> animation = AnimationUtils.loadAnimation(this, R.anim.myrotate)
            MENU_COMBO.id -> animation = AnimationUtils.loadAnimation(this, R.anim.mycombo)
        }
        //запускаем анимацию для компонента TextView
        if (this::animation.isInitialized) {
            textView.startAnimation(animation)
        } else {
            Log.d("myLogs", "animation isn't initialized")
        }
        return super.onContextItemSelected(item)
    }
}