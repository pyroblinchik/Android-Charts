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
        entries.add(PieEntry(0.2f, "Работа"))
        entries.add(PieEntry(0.15f, "Личное"))
        entries.add(PieEntry(0.4f, "Прочее"))
        entries.add(PieEntry(0.05f, "Автор"))
        entries.add(PieEntry(0.1f, "Автор"))
        entries.add(PieEntry(0.2f, "Автор"))
        entries.add(PieEntry(0.2f, "Автор"))
        val colors: ArrayList<Int> = ArrayList()

        val colorOfChart = intArrayOf(
            Color.rgb(211, 211, 211), Color.rgb(255, 147, 52), Color.rgb(50, 74, 203),
            Color.rgb(2, 135, 59), Color.rgb(242, 201, 76),Color.rgb(240,8,8)
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