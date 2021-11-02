package ru.startandroid.p0321simplebrowser

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

const val YANDEX_RU_WEB_ADDRESS = "https://www.ya.ru"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonWeb).setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(YANDEX_RU_WEB_ADDRESS)))
        }
    }
}