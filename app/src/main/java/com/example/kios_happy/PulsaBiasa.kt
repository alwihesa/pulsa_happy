package com.example.kios_happy

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_pulsa_biasa.*
import android.content.Intent
import android.net.Uri


class PulsaBiasa : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pulsa_biasa)

        btn_kirim_pls_biasa.setOnClickListener {
            val nomorTujuan = ed_nmr_tlpn.text.toString()
            val jumlahPulsa = ed_pulsa.text.toString()
            if(nomorTujuan.isNullOrEmpty()){
                applicationContext.toast("nomor telpon atau pulsa kosong!")
            }else {
                kirimPulsa(nomorTujuan, jumlahPulsa)
            }
        }
    }

    private fun kirimPulsa(nomorTujuan: String, jumlahPulsa: String){
        val kirim = "tel:" + "*777*" + nomorTujuan + "*"+jumlahPulsa+"*999"+Uri.encode("#")
        val intent = Intent(Intent.ACTION_CALL);
        intent.data = Uri.parse(kirim)
        startActivity(intent)
    }

    private fun Context.toast(message: String){
        Toast.makeText(this,message, Toast.LENGTH_LONG).show() }
}
