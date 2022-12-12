package com.pyroblinchik.charts

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.pyroblinchik.charts.databinding.ActivityPieChartBinding


class PieChartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPieChartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pie_chart)

        binding = ActivityPieChartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupPieChart()
        loadPieChartData()

    }

    private fun setupPieChart() {
        with(binding){
            activityMainPiechart.isDrawHoleEnabled = true
            activityMainPiechart.setDrawEntryLabels(false)
            activityMainPiechart.setDrawSlicesUnderHole(false)
            activityMainPiechart.setDrawRoundedSlices(true)
            activityMainPiechart.setUsePercentValues(true)
            activityMainPiechart.setDrawCenterText(true)
            activityMainPiechart.holeRadius = 70f
//            activityMainPiechart.dataS
//            activityMainPiechart.isDrawSlicesUnderHoleEnabled

            activityMainPiechart.getDescription().setEnabled(false)
            val l: Legend = activityMainPiechart.getLegend()
            l.verticalAlignment = Legend.LegendVerticalAlignment.TOP
            l.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
            l.orientation = Legend.LegendOrientation.VERTICAL
            l.setDrawInside(false)
            l.isEnabled = true
        }
    }

    private fun loadPieChartData() {
        val entries: ArrayList<PieEntry> = ArrayList()
        entries.add(PieEntry(0.2f, "Food & Dining"))
        entries.add(PieEntry(0.15f, "Medical"))
        entries.add(PieEntry(0.10f, "Entertainment"))
        entries.add(PieEntry(0.25f, "Electricity and Gas"))
        entries.add(PieEntry(0.3f, "Housing"))
        val colors: ArrayList<Int> = ArrayList()
        val colorsMaterial = intArrayOf(
            ColorTemplate.rgb("#2ecc71"),
            ColorTemplate.rgb("#f1c40f"),
            ColorTemplate.rgb("#e74c3c"),
            ColorTemplate.rgb("#3498db")
        )
        for (color in colorsMaterial) {
            colors.add(color)
        }
        val colorOfChart = intArrayOf(
            Color.rgb(192, 155, 140), Color.rgb(245, 247, 100), Color.rgb(255, 208, 140),
            Color.rgb(240, 134, 255), Color.rgb(255, 140, 157)
        )
        for (color in colorOfChart) {
            colors.add(color)
        }
        val dataSet = PieDataSet(entries, "Expense Category")
        dataSet.colors = colors
        val data = PieData(dataSet)
        data.setDrawValues(false)
        binding.activityMainPiechart.setData(data)
        binding.activityMainPiechart.invalidate()
        binding.activityMainPiechart.animateY(1400, Easing.EaseInOutQuad)
    }


    companion object {

        fun start(activity: Activity) {
            val i = Intent(activity, PieChartActivity::class.java)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            activity.startActivity(i)
        }
    }
}