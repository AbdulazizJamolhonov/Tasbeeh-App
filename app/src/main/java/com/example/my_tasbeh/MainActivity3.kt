package com.example.my_tasbeh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        if (MyData.vibr == true) {
            vibratsiya.isChecked = true
        }

        vibratsiya.setOnCheckedChangeListener { compoundButton, b ->
            MyData.vibr = b
        }
        save.setOnClickListener {
            MyData.text = edt_salovat.text.toString()
            finish()
        }
    }
}