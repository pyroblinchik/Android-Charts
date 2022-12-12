package com.pyroblinchik.charts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pyroblinchik.charts.databinding.ActivityMainBinding
import com.pyroblinchik.charts.databinding.ActivityPieChartBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.buttonPie.setOnClickListener {
            PieChartActivity.start(this)
        }

        binding.buttonBar.setOnClickListener {
            BarChartActivity.start(this)
        }
    }
}