package ru.startandroid.p0311simpleintents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var buttonWeb: Button
    lateinit var buttonMap: Button
    lateinit var buttonCall: Button

    val httpAddress = "http://developer.android.com"
    val coordinates = "geo:55.754283,37.62002"
    val numberOfPhone = "tel:12345"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonWeb = findViewById(R.id.button_web)
        buttonMap = findViewById(R.id.button_map)
        buttonCall = findViewById(R.id.button_call)

        buttonWeb.setOnClickListener(this)
        buttonMap.setOnClickListener(this)
        buttonCall.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent: Intent
        when(v?.id) {
            R.id.button_web -> {
                /*
                    1-ый способ создания Intent - воспользуемся конструктором, который на
                        вход принимает action и data.
                        ACTION_VIEW - стандартный системный action, константа, означает, что
                        мы хотим просмотреть что-либо
                 */

                intent = Intent(Intent.ACTION_VIEW, Uri.parse(httpAddress))
                startActivity(intent)
            }
            R.id.button_map -> {
                /*
                    2-ой способ создания Intent - создаем объект Intent и присваиваем ему атрибуты
                        action и data
                 */
                intent = Intent()
                intent.action = Intent.ACTION_VIEW
                intent.data = Uri.parse(coordinates)
                startActivity(intent)
            }
            R.id.button_call -> {
                /*
                    3-ий способ создания Intent - используем конструктор, который принимает только
                        action - в данном случае ACTION_DIAL - открывает звонилку и набирает номер,
                        но не начинает звонок.
                 */
                intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse(numberOfPhone)
                startActivity(intent)
            }
        }
    }
}