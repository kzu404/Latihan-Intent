package com.kzu404.tutorial01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtName: EditText
    private lateinit var btnCetak: Button
    private lateinit var tvResult: TextView
    private lateinit var btnIntent: Button
    private lateinit var btnIntentData: Button
    private lateinit var btnShare: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtName = findViewById(R.id.edt_name)
        btnCetak = findViewById(R.id.btn_cetak)
        tvResult = findViewById(R.id.tv_result)
        btnIntent = findViewById(R.id.btn_intent)
        btnIntentData = findViewById(R.id.btn_intent_data)
        btnShare = findViewById(R.id.btn_share)

        btnCetak.setOnClickListener(this)
        btnIntent.setOnClickListener(this)
        btnIntentData.setOnClickListener(this)
        btnShare.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_cetak -> tvResult.text = "Hello ${edtName.text}"
            R.id.btn_intent -> {
                val moveIntent = Intent(this@MainActivity, DetailActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_intent_data -> {
                val address = Address("Jln. Tri Darma", 3)
                val moveDataIntent = Intent(this@MainActivity, DetailActivity::class.java)
                moveDataIntent.putExtra(DetailActivity.ADDRESS_EXTRA, address)
                startActivity(moveDataIntent)
            }
            R.id.btn_share -> {
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
                    type = "text/plain"
                }
                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }
        }
    }
}