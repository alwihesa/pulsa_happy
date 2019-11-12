package com.example.kios_happy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
