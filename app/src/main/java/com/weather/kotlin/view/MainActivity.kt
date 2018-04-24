package com.weather.kotlin.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.weather.kotlin.R
import com.weather.kotlin.data.Request
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity(), AnkoLogger {

    val url = "http://api.openweathermap.org/data/2.5/forecast/daily?" +
            "APPID=15646a06818f61f7b8d7823ca833e1ce&q=94043&mode=json&units=metric&cnt=7"


    private val items = listOf(
            "Mon 6/23 - Sunny  - 31/17",
            "Tue 6/24 - Cloudy  - 31/17",
            "Wed 6/25 - Rain  - 31/17",
            "Thurs 6/26 - Sunny  - 31/17",
            "Fri 6/27 - Sunny  - 31/17",
            "Sat 6/28 - Rain  - 31/17",
            "Sun 6/29 - Cloudy  - 31/17"
    )

    override fun onCreate(savecdInstanceState: Bundle?) {
        super.onCreate(savecdInstanceState)
        setContentView(R.layout.activity_main)

        val forecastList: RecyclerView = find(R.id.forecastList)
        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.adapter = ForecastListAdapter(items)

        doAsync {
            Request(url).run()
            uiThread {
                longToast("Request performed")
                debug("")
            }
        }
    }
}
