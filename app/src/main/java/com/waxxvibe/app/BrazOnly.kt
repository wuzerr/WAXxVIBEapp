package com.waxxvibe.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import kotlin.math.round
import java.math.BigDecimal
import java.math.RoundingMode



class BrazOnly : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_braz_only)
        val seekBar = findViewById<SeekBar>(R.id.DemoSlider)
        seekBar.setOnTouchListener(SeekBarTouchListener())
        initializeView()
        configureButtons()
    }
    private fun initializeView() {
        // create objects of TextView and Seekbar
        val sliderValue: TextView = findViewById(R.id.number_viewer)
        val sliderValue1: TextView = findViewById(R.id.number_viewer1)
        val sliderValue2: TextView = findViewById(R.id.number_viewer2)
        val sliderValue3: TextView = findViewById(R.id.number_viewer3)
        val sliderValue4: TextView = findViewById(R.id.number_viewer4)
        val tipValue1: TextView = findViewById(R.id.tip_number1)
        val tipValue2: TextView = findViewById(R.id.tip_number2)
        val tipValue3: TextView = findViewById(R.id.tip_number3)
        val slider: SeekBar = findViewById(R.id.DemoSlider)
        val customTip: EditText = findViewById(R.id.custom_tip_input)



        // set the max value of the slider using setMax function
        slider.max = 90


        slider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            // override the onProgressChanged method to perform operations
            // whenever the there a change in SeekBar
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if(customTip.length() == 0){
                    sliderValue4.text = "$" + progress.toString()
                }
                else{
                    sliderValue4.text = "$" + (customTip.getText().toString().toDouble() + progress).toString()
                }
                sliderValue.text = "$" + progress.toString()
                sliderValue1.text = "$" +(BigDecimal(progress*1.15).setScale(2, RoundingMode.HALF_EVEN)).toString()
                sliderValue2.text = "$" +(BigDecimal(progress*1.2).setScale(2, RoundingMode.HALF_EVEN)).toString()
                sliderValue3.text = "$" +(BigDecimal(progress*1.25).setScale(2, RoundingMode.HALF_EVEN)).toString()

                tipValue1.text = "$" + (BigDecimal(progress * 0.15).setScale(2, RoundingMode.HALF_EVEN)).toString()
                tipValue2.text = "$" + (BigDecimal(progress * 0.20).setScale(2, RoundingMode.HALF_EVEN)).toString()
                tipValue3.text = "$" + (BigDecimal(progress * 0.25).setScale(2, RoundingMode.HALF_EVEN)).toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        customTip.addTextChangedListener(object  : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                if(customTip.length() == 0){
                    sliderValue4.text = "$" + slider.progress.toString()
                }
                else {
                    sliderValue4.text = "$" + (customTip.getText().toString()
                        .toDouble() + slider.progress).toString()
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

        })
    }

    private fun configureButtons() {
        val backButton = findViewById<Button>(R.id.backbutton)
        backButton.setOnClickListener {
            val intent = Intent(this@BrazOnly, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}