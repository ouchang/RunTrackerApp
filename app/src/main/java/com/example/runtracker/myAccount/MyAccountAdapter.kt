package com.example.runtracker.myAccount

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.runtracker.R

class MyAccountAdapter(private val menuItem : ArrayList<MyAccountItem>, private var onBlockListener: OnMyAccountClickListener)
    : RecyclerView.Adapter<MyAccountViewHolder>() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAccountViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.my_account_item, parent, false)
        val layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            parent.height / 7
        )
        view.layoutParams = layoutParams
        return MyAccountViewHolder(view, onBlockListener)
    }

    override fun getItemCount(): Int {
        return menuItem.size
    }

    override fun onBindViewHolder(holder: MyAccountViewHolder, position: Int) {
        sharedPreferences =
            holder.view.context.getSharedPreferences("my_account", Context.MODE_PRIVATE)

        holder.textViewTitle.text = menuItem[position].item
        holder.textViewData.text = sharedPreferences.getString(menuItem[position].item, "")
    }

    interface OnMyAccountClickListener {
        fun onBlockClick(position: Int)
    }
}