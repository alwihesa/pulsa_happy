package com.example.kios_happy

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_token.*
import java.lang.Exception

class Token : AppCompatActivity() {
    private var tokenValue = "20"
    private var destinationNumber : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_token)

        rg_pulsa.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == 0) {
                tokenValue = "" +getString(R.string.pls_20)
                applicationContext.toast(tokenValue)}
            if (checkedId == 1){
                tokenValue = "" +getString(R.string.pls_50)
                applicationContext.toast(tokenValue)}
            if (checkedId == 2){
                tokenValue = "" +getString(R.string.pls_100)
                applicationContext.toast(tokenValue)}
            if (checkedId == 3){
                tokenValue = "" +getString(R.string.pls_200)
                applicationContext.toast(tokenValue)}
        }

        rg_nmr.setOnCheckedChangeListener { _, checkedId ->
            destinationNumber = " " + getString(if (checkedId == 0) R.string.nmr1 else R.string.nmr2)
            applicationContext.toast(destinationNumber)
        }

        btn_kirim2.setOnClickListener {
            sendSMS2(destinationNumber, tokenValue, tokenValue)
        }

    }

    private fun Context.toast(message: String){
        Toast.makeText(this,message, Toast.LENGTH_LONG).show() }

    private fun sendSMS(sendTo: String, tokenValue: String, pulsaValue: String) {
        try {
            val uri = Uri.parse("smsto:$sendTo")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "$tokenValue + $pulsaValue")
            startActivity(intent)
            applicationContext.toast("SMS berhasil dikirim!")
        } catch (e: Exception) {
            applicationContext.toast("SMS gagal dikirim!")
        }

    }

    private fun sendSMS2 (sendTo: String, tokenValue: String, pulsaValue: String) {
        val smsManager = SmsManager.getDefault() as SmsManager
        smsManager.sendTextMessage(sendTo, null, "$tokenValue, $pulsaValue dong mbak", null, null)
        applicationContext.toast("SMS berhasil dikirim!")
    }
}
