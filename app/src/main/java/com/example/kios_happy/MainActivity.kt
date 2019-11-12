package com.example.kios_happy

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val listPermission: Array<out String> = arrayOf(
        android.Manifest.permission.CALL_PHONE, android.Manifest.permission.SEND_SMS
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= 23) {
            requestPermissions(
                listPermission,
                2
            )
        }

        btn_pulsa_biasa.setOnClickListener {
            val intent = Intent(this, PulsaBiasa::class.java)
            startActivity(intent)
        }

        btn_token.setOnClickListener{
            val intent = Intent(this, Token::class.java)
            startActivity(intent)
        }


    }
}
