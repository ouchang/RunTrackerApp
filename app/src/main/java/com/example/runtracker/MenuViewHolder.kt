package com.example.runtracker

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MenuViewHolder(val view : View,var onBlockListener : MenuAdapter.OnBlockClickListener) : RecyclerView.ViewHolder(view),View.OnClickListener {

    var text  = view.findViewById<TextView>(R.id.text)
    var image = view.findViewById<ImageView>(R.id.image)

    init{
        view.setOnClickListener(this)
    }



    override fun onClick(v: View?) {
        Toast.makeText(view.context,text.text,Toast.LENGTH_SHORT).show()
    }
}