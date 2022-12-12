package com.pyroblinchik.charts

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.pyroblinchik.charts.databinding.ActivityBarChartBinding

class BarChartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBarChartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bar_chart)

        binding = ActivityBarChartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBarChart()
        loadBarChartData()

    }

    private fun setupBarChart() {
        with(binding){
//            activityMainBarchart.isDrawHoleEnabled = true
//            activityMainBarchart.setDrawEntryLabels(false)
//            activityMainBarchart.setDrawSlicesUnderHole(false)
//            activityMainBarchart.setDrawRoundedSlices(true)
//            activityMainBarchart.setUsePercentValues(true)
//            activityMainBarchart.setDrawCenterText(true)
//            activityMainBarchart.holeRadius = 70f
//            activityMainPiechart.dataS
//            activityMainPiechart.isDrawSlicesUnderHoleEnabled

            activityMainBarchart.getDescription().setEnabled(false)
            val l: Legend = activityMainBarchart.getLegend()
            l.verticalAlignment = Legend.LegendVerticalAlignment.TOP
            l.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
            l.orientation = Legend.LegendOrientation.VERTICAL
            l.setDrawInside(false)
            l.isEnabled = true
        }
    }

    private fun loadBarChartData() {
        val entries: ArrayList<BarEntry> = ArrayList()
        entries.add(BarEntry(0.2f, 0.2f))
        entries.add(BarEntry(0.15f, 0.15f))
        entries.add(BarEntry(0.10f, 0.10f))
        entries.add(BarEntry(0.25f, 0.25f))
        entries.add(BarEntry(0.3f, 0.3f))
        val colors: ArrayList<Int> = ArrayList()
        for (color in ColorTemplate.MATERIAL_COLORS) {
            colors.add(color)
        }
        for (color in ColorTemplate.MATERIAL_COLORS) {
            colors.add(color)
        }
        val dataSet = BarDataSet(entries, "Expense Category")
        dataSet.colors = colors
        val data = BarData(dataSet)
        data.setDrawValues(false)
        binding.activityMainBarchart.setData(data)
        binding.activityMainBarchart.invalidate()
        binding.activityMainBarchart.animateY(5000)
    }

    companion object {

        fun start(activity: Activity) {
            val i = Intent(activity, BarChartActivity::class.java)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            activity.startActivity(i)
        }
    }
}