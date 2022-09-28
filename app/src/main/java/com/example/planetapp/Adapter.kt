package com.example.planetapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view.view.*

class Adapter(var planet:List<PlanetData>): RecyclerView.Adapter<Adapter.myViewHolder>() {

    class myViewHolder(view: View) :RecyclerView.ViewHolder(view){
        var title=view.title
        var planetimg=view.planet_img
        var galaxy=view.galaxy
        var distance=view.distance
        var gravity=view.gravity

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.view,parent,false)
        return myViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        var dummmyImage:Int?=null
        holder.itemView.setOnClickListener{
            val intent= Intent(holder.itemView.context,PlanetDetails::class.java)
            intent.putExtra("planet",planet[position])
            intent.putExtra("PlanetImage",dummmyImage)
            holder.itemView.context.startActivity(intent)
        }
        holder.title.text=planet[position].title
        holder.galaxy.text=planet[position].galaxy
        holder.distance.text=planet[position].distance + "m Km"
        holder.gravity.text=planet[position].gravity + "m/ss"


        when(planet[position].title!!.toLowerCase()){
            "earth"->{
                dummmyImage=R.drawable.ic_earth
            }
            "mars"->{
                dummmyImage=R.drawable.ic_mars
            }
            "neptune"->{
                dummmyImage=R.drawable.ic_neptune
            }
            "uranus"->{
                dummmyImage=R.drawable.ic_uranus
            }
            "sun"->{
                dummmyImage=R.drawable.ic_sun
            }
            "saturn"->{
                dummmyImage=R.drawable.ic_saturn
            }
            "jupiter"->{
            dummmyImage=R.drawable.ic_jupiter
            }
            "moon"->{
                dummmyImage=R.drawable.ic_moon
            }
            "venus"->{
                dummmyImage=R.drawable.ic_venus
            }
            "mercury"->{
                dummmyImage=R.drawable.ic_mercury
            }

        }
        holder.planetimg.setImageResource(dummmyImage!!)
    }



    override fun getItemCount(): Int {
        return planet.size
    }

}

