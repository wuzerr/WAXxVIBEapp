package com.waxxvibe.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import android.widget.EditText
import android.text.Editable
import android.widget.Button

class BrazPlusAddOn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_braz_plus_add_on)
        initializeView()
        configureButtons()
    }

    private fun initializeView(){
        val slider: SeekBar = findViewById(R.id.DemoSlider)
        val sliderValue: TextView = findViewById(R.id.number_viewer)

        // set the max value of the slider using setMax function
        slider.max = 90

        slider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                sliderValue.text = "$" + progress.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })
    }

    private fun configureButtons() {
        val backButton = findViewById<Button>(R.id.backbutton)
        backButton.setOnClickListener {
            val intent = Intent(this@BrazPlusAddOn, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}