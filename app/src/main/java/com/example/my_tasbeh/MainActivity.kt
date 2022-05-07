package com.example.my_tasbeh

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val anim1 = AnimationUtils.loadAnimation(this, R.anim.translate1)
        text_bosh_ekran1.startAnimation(anim1)

        val anim2 = AnimationUtils.loadAnimation(this, R.anim.translate2)
        text_bosh_ekran2.startAnimation(anim2)

        val anim3 = AnimationUtils.loadAnimation(this, R.anim.translate3)
        text_bosh_ekran3.startAnimation(anim3)

        val anim4 = AnimationUtils.loadAnimation(this, R.anim.translate4)
        text_bosh_ekran4.startAnimation(anim4)

        activity_1.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
            finish()
        }
    }
}