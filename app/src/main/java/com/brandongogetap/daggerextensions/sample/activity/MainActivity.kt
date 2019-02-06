package com.brandongogetap.daggerextensions.sample.activity

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.brandongogetap.daggerextensions.sample.R
import com.brandongogetap.daggerextensions.sample.counter.Counter
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var counter: Counter

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countText = findViewById<TextView>(R.id.tv_count)
        countText.text = counter.getCount().toString()

        findViewById<View>(R.id.btn_increment).setOnClickListener {
            countText.text = counter.incrementAndGetCount().toString()
        }
    }
}
