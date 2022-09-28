package com.example.planetapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_planet_details.*

class PlanetDetails : AppCompatActivity() {
    private lateinit var obj:PlanetData
    private  var planetimg:Int?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planet_details)
        window.decorView.apply{systemUiVisibility=
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN}

        obj= intent.getParcelableExtra("planet")!!
        planetimg=intent.getIntExtra("PlanetImage",-1)
        setdata(obj,planetimg!!)

        buton_info.setOnClickListener{
            val intent= Intent(this,FinalActivity::class.java)
            startActivity(intent)
        }
    }
    private fun setdata(obj:PlanetData,planetImg:Int){
        title_info.text=obj.title
        distance_info.text=obj.distance + "Km"
        gravity_info.text=obj.gravity + "m/ss"
        galaxy_info.text=obj.galaxy
        overview_info.text=obj.overview
        planet_img_info.setImageResource(planetImg)
    }
}