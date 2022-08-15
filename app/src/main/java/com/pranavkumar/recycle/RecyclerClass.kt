package com.pranavkumar.recycle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerClass (var array: ArrayList<StudentInfo>) : RecyclerView.Adapter<RecyclerClass.ViewHolder> (){
    class ViewHolder(var view: View): RecyclerView.ViewHolder(view) {
        var tvEnterId :TextView = view.findViewById(R.id.tvEnterid)
        var tvEntername :TextView = view.findViewById(R.id.tvEntername)
        var tvEnterPhone :TextView = view.findViewById(R.id.tvEnterphone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var initview = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)

        return ViewHolder(initview)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvEnterId.setText(array[position].id.toString())
        holder.tvEntername.setText(array[position].name.toString())
        holder.tvEnterPhone.setText(array[position].phone.toString())


    }

    override fun getItemCount(): Int {
        return array.size

    }

}