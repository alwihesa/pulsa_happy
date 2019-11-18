package com.example.kios_happy

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_pulsa_biasa.*
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AlertDialog


class PulsaBiasa : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pulsa_biasa)

        btn_kirim_pls_biasa.setOnClickListener {
            val nomorTujuan = ed_nmr_tlpn.text.toString()
            val jumlahPulsa = ed_pulsa.text.toString()
            if(nomorTujuan.isEmpty()){
                applicationContext.toast("Nomor telpon atau pulsa kosong!")
            }else {
                kirimPulsa(nomorTujuan, jumlahPulsa)

                // Initialize a new instance of
                val builder = AlertDialog.Builder(this)

                builder.setCancelable(false)

                // Set the alert dialog title
                builder.setTitle("PEMBELIAN PULSA DIPROSES!")

                // Display a message on alert dialog
                builder.setMessage("Pembelian pulsa sedang diproses, cek SMS untuk informasi lebih lanjut!")

                // Set a positive button and its click listener on alert dialog
                builder.setPositiveButton("SELESAI"){dialog, which ->
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }

                // Finally, make the alert dialog using builder
                val dialog: AlertDialog = builder.create()

                // Display the alert dialog on app interface
                dialog.show()
            }


        }
    }

    private fun kirimPulsa(nomorTujuan: String, jumlahPulsa: String){
        val kirim = "tel:" + "*777*" + nomorTujuan + "*"+jumlahPulsa+"*999"+Uri.encode("#")
        val intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse(kirim)
        startActivity(intent)
    }

    private fun Context.toast(message: String){
        Toast.makeText(this,message, Toast.LENGTH_LONG).show() }
}
