package com.example.my_tasbeh

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Vibrator
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        settings2.isVisible = false
        settings3.isVisible = false
        start()
    }

    private fun start() {
        var a1 = true
        var b1 = false
        var c1 = false
        var d1 = false
        var e1 = false
        colors.setOnClickListener {
            when {
                a1 -> {
                    text_count.setTextColor(Color.parseColor("#000000"))
                    salovat.setTextColor(Color.parseColor("#000000"))
                    a1 = false
                    b1 = true
                }
                b1 -> {
                    text_count.setTextColor(Color.parseColor("#63FF00"))
                    salovat.setTextColor(Color.parseColor("#63FF00"))
                    b1 = false
                    c1 = true
                }
                c1 -> {
                    text_count.setTextColor(Color.parseColor("#0044FF"))
                    salovat.setTextColor(Color.parseColor("#0044FF"))
                    c1 = false
                    d1 = true
                }
                d1 -> {
                    text_count.setTextColor(Color.parseColor("#FFFFFF"))
                    salovat.setTextColor(Color.parseColor("#FFFFFF"))
                    d1 = false
                    e1 = true
                }
                e1 -> {
                    text_count.setTextColor(Color.parseColor("#FFAB00"))
                    salovat.setTextColor(Color.parseColor("#FFAB00"))
                    e1 = false
                    a1 = true
                }
            }
//            when (Random.nextInt(5)) {
//                0 -> {
//                    text_count.setTextColor(Color.parseColor("#000000"))
//                    salovat.setTextColor(Color.parseColor("#000000"))
//                }
//                1 -> {
//                    text_count.setTextColor(Color.parseColor("#63FF00"))
//                    salovat.setTextColor(Color.parseColor("#63FF00"))
//                }
//                2 -> {
//                    text_count.setTextColor(Color.parseColor("#0044FF"))
//                    salovat.setTextColor(Color.parseColor("#0044FF"))
//                }
//                3 -> {
//                    text_count.setTextColor(Color.parseColor("#FFFFFF"))
//                    salovat.setTextColor(Color.parseColor("#FFFFFF"))
//                }
//                4 -> {
//                    text_count.setTextColor(Color.parseColor("#FFAB00"))
//                    salovat.setTextColor(Color.parseColor("#FFAB00"))
//                }
//            }
        }

        settings1.setOnClickListener {
            if (!settings2.isVisible && !settings2.isVisible) {
                val anim = AnimationUtils.loadAnimation(this, R.anim.rotate)
                img_set1.startAnimation(anim)
                settings2.isVisible = true
                val anim1 = AnimationUtils.loadAnimation(this, R.anim.alpha_set1)
                settings2.startAnimation(anim1)
                settings3.isVisible = true
                val anim2 = AnimationUtils.loadAnimation(this, R.anim.alpha_set2)
                settings3.startAnimation(anim2)
            } else {
                val anim = AnimationUtils.loadAnimation(this, R.anim.rotate2)
                img_set1.startAnimation(anim)
                val anim3 = AnimationUtils.loadAnimation(this, R.anim.alpha_set2_1)
                settings2.startAnimation(anim3)
                settings2.isVisible = false
                val anim1 = AnimationUtils.loadAnimation(this, R.anim.alpha_set1_1)
                settings3.startAnimation(anim1)
                settings3.isVisible = false
            }
        }
        settings2.setOnClickListener {
            startActivity(Intent(this, MainActivity3::class.java))
        }
        settings3.setOnClickListener {
            startActivity(Intent(this, MainActivity4::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        if (MyData.text != "") {
            salovat.text = MyData.text
            salovat.setPadding(0, 60, 0, 0)
        }

        var a = 0
        btn_count.setOnClickListener {
            if (MyData.vibr == true) {
                val vibrator = this.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                vibrator.vibrate(200)
                if (text_count.text.length != 6)
                    text_count.text = "${++a}"
            } else {
                if (text_count.text.length != 6)
                    text_count.text = "${++a}"
            }
        }
        clear.setOnLongClickListener {
            if (MyData.vibr == true) {
                val vibrator = this.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                vibrator.vibrate(200)
                text_count.text = "0"
                a = 0
            } else {
                text_count.text = "0"
                a = 0
            }
            true
        }
        clear.setOnClickListener {
            if (MyData.vibr == true) {
                val vibrator = this.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
                vibrator.vibrate(200)
                if (text_count.text != "0" && text_count.text.toString().toInt() > 0)
                    text_count.text = "${--a}"
            } else {
                if (text_count.text != "0" && text_count.text.toString().toInt() > 0)
                    text_count.text = "${--a}"
            }
        }
    }
}