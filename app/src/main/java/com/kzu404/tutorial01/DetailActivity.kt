package com.kzu404.tutorial01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    companion object {
        const val ADDRESS_EXTRA = "address_extra"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvDetail: TextView = findViewById(R.id.tv_detail)
        val address = intent.getParcelableExtra<Address>(ADDRESS_EXTRA) as? Address
        if (address != null) {
            tvDetail.text = "Alamat: ${address?.street}, RT ${address?.number}"
        }
    }
}