package com.ralvez.myapplicationlayout02

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ralvez.myapplicationlayout02.databinding.ExampleItemBinding

class Adapter(val list:ArrayList<Info>):RecyclerView.Adapter<Adapter.MyView>() {

    inner class MyView(val itemBinding: ExampleItemBinding):RecyclerView.ViewHolder(itemBinding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        return MyView(ExampleItemBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.itemBinding.imageView.setImageResource(list[position].image)
        holder.itemBinding.textView1.text = list[position].name

    }


}