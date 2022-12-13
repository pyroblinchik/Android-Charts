package com.pyroblinchik.charts

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.pyroblinchik.charts.databinding.ActivityBarChartBinding

class BarChartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBarChartBinding
    private var barEntryList: ArrayList<BarEntry>? = arrayListOf()
    private var stringsNamesList: ArrayList<String>? = arrayListOf()

    private var remarksByCategoriesList: ArrayList<RemarksByCategories>? = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bar_chart)

        binding = ActivityBarChartBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setupBarChart()
//        loadBarChartData()
//        barEntryList = arrayListOf()
//        stringsNamesList = arrayListOf()
        getData()

        loadBarChartData()
    }

    private fun getData(){

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

        }
    }

    private fun loadBarChartData() {
//        val entries: ArrayList<BarEntry> = ArrayList()
//        entries.add(BarEntry("A", 5f))
//        entries.add(BarEntry("B", 47f))
//        entries.add(BarEntry("C", 12f))
//        entries.add(BarEntry("D", 11f))
//        entries.add(BarEntry("E", 34))
        remarksByCategoriesList?.add(RemarksByCategories(0,"Пусто",600))
        remarksByCategoriesList?.add(RemarksByCategories(1,"A",100))
        remarksByCategoriesList?.add(RemarksByCategories(2,"B",300))
        remarksByCategoriesList?.add(RemarksByCategories(3,"C",500))
        remarksByCategoriesList?.add(RemarksByCategories(4,"D",200))
        remarksByCategoriesList?.add(RemarksByCategories(5,"E",600))
        remarksByCategoriesList?.add(RemarksByCategories(6,"F",100))
        remarksByCategoriesList?.add(RemarksByCategories(7,"G",300))
        remarksByCategoriesList?.add(RemarksByCategories(8,"X",500))
        remarksByCategoriesList?.add(RemarksByCategories(9,"Y",200))
        remarksByCategoriesList?.add(RemarksByCategories(10,"Z",600))
        remarksByCategoriesList?.add(RemarksByCategories(11,"Q",100))
        remarksByCategoriesList?.add(RemarksByCategories(12,"R",300))
        remarksByCategoriesList?.add(RemarksByCategories(13,"T",500))
        remarksByCategoriesList?.add(RemarksByCategories(14,"U",200))


        remarksByCategoriesList?.forEach {
            stringsNamesList?.add(it.categoryName!!)
            barEntryList?.add(BarEntry(it.id.toFloat(),it.remarksCount!!.toFloat()))
        }
        val colorsTemplate = intArrayOf(
            Color.rgb(74, 160, 150), Color.rgb(74, 160, 150), Color.rgb(74, 160, 150),
            Color.rgb(74, 160, 150), Color.rgb(74, 160, 150)
        )
        val colors: ArrayList<Int> = ArrayList()
        for (color in colorsTemplate) {
            colors.add(color)
        }
        val dataSet = BarDataSet(barEntryList, "Колличество по категориям")
        dataSet.colors = colors
        dataSet.barBorderWidth = 10f
        dataSet.barBorderColor = 42222
        val data = BarData(dataSet)
        data.setDrawValues(true)
        binding.activityMainBarchart.setData(data)

        val xAxis = binding.activityMainBarchart.getXAxis()
        xAxis.valueFormatter = IndexAxisValueFormatter(stringsNamesList)
        xAxis.position = (XAxis.XAxisPosition.BOTTOM)
        xAxis.setDrawGridLines(false)
        xAxis.setDrawAxisLine(false)
        xAxis.granularity = 1f
        xAxis.labelCount = stringsNamesList!!.size
        xAxis.labelRotationAngle = 360f

        binding.activityMainBarchart.legend.isEnabled = false
        binding.activityMainBarchart.description.isEnabled = false
        binding.activityMainBarchart.axisRight.isEnabled = false

        val axisLeft = binding.activityMainBarchart.axisLeft

//        axisLeft.axisDependency
//        binding.activityMainBarchart.setScaleEnabled(false)

        binding.activityMainBarchart.animateY(1000)
        binding.activityMainBarchart.invalidate()
    }

    companion object {

        fun start(activity: Activity) {
            val i = Intent(activity, BarChartActivity::class.java)
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            activity.startActivity(i)
        }
    }
}