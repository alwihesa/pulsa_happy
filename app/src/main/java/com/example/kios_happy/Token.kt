package com.example.kios_happy

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_token.*

class Token : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_token)

        rg_nmr.setOnCheckedChangeListener { group, checkedId ->
            val nmr_krim = " " + getString(if (checkedId == 0) R.string.nmr1 else R.string.nmr2)
            applicationContext.toast(nmr_krim)
        }

        rg_pulsa.setOnCheckedChangeListener { group, checkedId ->
            var nilai_token = "20"
            if (checkedId == 0) {
                nilai_token = "" +getString(R.string.pls_20)
                applicationContext.toast(nilai_token)}
            if (checkedId == 1){
                nilai_token = "" +getString(R.string.pls_50)
                applicationContext.toast(nilai_token)}
            if (checkedId == 2){
                nilai_token = "" +getString(R.string.pls_100)
                applicationContext.toast(nilai_token)}
            if (checkedId == 3){
                nilai_token = "" +getString(R.string.pls_200)
                applicationContext.toast(nilai_token)}


        }

    }

    private fun Context.toast(message: String){
        Toast.makeText(this,message, Toast.LENGTH_LONG).show() }
}
