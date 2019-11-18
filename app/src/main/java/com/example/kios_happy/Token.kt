package com.example.kios_happy

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_token.*
import java.lang.Exception

class Token : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_token)

        btn_kirim2.setOnClickListener {
            val noToken = ed_nmr_token.text.toString()
            if(noToken.isNullOrEmpty()){
                applicationContext.toast("Nomor Token Kosong!")
            }else {
                val jumlahTokenDibeli = findViewById<RadioButton>(rg_pulsa.checkedRadioButtonId)
                val destinationNumber = findViewById<RadioButton>(rg_nmr.checkedRadioButtonId)
                sendSMS2(
                    destinationNumber.text.toString(),
                    jumlahTokenDibeli.text.toString(),
                    noToken
                )
            }
        }
    }

    private fun Context.toast(message: String){
        Toast.makeText(this,message, Toast.LENGTH_LONG).show() }


    private fun sendSMS2 (sendTo: String, tokenValue: String, userToken: String) {
        try{
            val smsManager = SmsManager.getDefault() as SmsManager
            smsManager.sendTextMessage(sendTo, null, "$userToken $tokenValue dong mbak", null, null)

            // Initialize a new instance of
            val builder = AlertDialog.Builder(this)

            builder.setCancelable(false)

            // Set the alert dialog title
            builder.setTitle("PEMBELIAN TOKEN DIPROSES!")

            // Display a message on alert dialog
            builder.setMessage("Pembelian Token sedang diproses, cek SMS untuk informasi lebih lanjut!")

            // Set a positive button and its click listener on alert dialog
            builder.setPositiveButton("SELESAI"){dialog, which ->
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

            // Finally, make the alert dialog using builder
            val dialog: AlertDialog = builder.create()

            // Display the alert dialog on app interface
            dialog.show()
        }catch (e:Exception) {
            val builder = AlertDialog.Builder(this)


            // Set the alert dialog title
            builder.setTitle("PEMBELIAN TOKEN GAGAL!")

            // Set a positive button and its click listener on alert dialog
            builder.setPositiveButton("SELESAI"){dialog, which ->
            }

            // Finally, make the alert dialog using builder
            val dialog: AlertDialog = builder.create()

            // Display the alert dialog on app interface
            dialog.show()
        }
    }
}
