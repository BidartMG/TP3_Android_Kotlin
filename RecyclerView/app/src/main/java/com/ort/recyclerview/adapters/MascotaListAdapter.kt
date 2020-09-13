package com.ort.recyclerview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.ort.recyclerview.R
import com.ort.recyclerview.entities.Mascota
import kotlinx.android.synthetic.main.item_mascota.view.*

class MascotaListAdapter (private var mascotasList:MutableList<Mascota>): RecyclerView.Adapter<MascotaListAdapter.MascotaHolder>() {

    companion object {
        private val TAG = "MascotaListAdapter"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MascotaHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mascota,parent,false)
        return (MascotaHolder(view))
    }

    override fun getItemCount(): Int {
        return mascotasList.size
    }

    fun setData (newData: ArrayList<Mascota>) {
        this.mascotasList = newData
        this.notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MascotaHolder, position: Int) {
        holder.setName(mascotasList[position].nombre)
        /*
        Glide


         */
        holder.getCardLayout().setOnClickListener() {
            //onItemClick(position)
            holder.setName("MONICA")
        }
    }

    class MascotaHolder (vista: View) : RecyclerView.ViewHolder(vista) {

        private var view: View

        init {
            this.view = vista
        }

        fun setName (name:String) {

            val txt: TextView = view.findViewById(R.id.txt_name_item)
            txt.text = name
        }


        fun getCardLayout (): CardView {
            return view.findViewById(R.id.card_package_item)
        }
/*
        fun getImageView (): ImageView {
            return view.findViewById(R.id.img_item)
        }
        */

    }


}