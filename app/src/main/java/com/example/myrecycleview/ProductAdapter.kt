package com.example.myrecycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val productList: List<Product>, private val listener:onItemClickListener): RecyclerView.Adapter<ProductAdapter.myViewHolder>() {

    inner class myViewHolder(itemView: View):RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val tvCode: TextView = itemView.findViewById(R.id.tvCode)
        val tvPrice:TextView = itemView.findViewById(R.id.tvPrice)
        val tvDescription : TextView = itemView.findViewById(R.id.tvDescription)
        val picProduct : ImageView = itemView.findViewById(R.id.picProduct)

        init{
                picProduct.setImageResource(R.drawable.ic_default)
        }

        override fun onClick(view: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION){
                listener.itemClick(position)
            }

        }
    }

    interface onItemClickListener{
        fun itemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)

        return myViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val currentProduct = productList[position]
        holder.tvCode.text = currentProduct.code
        holder.tvPrice.text = currentProduct.price.toString()
        holder.tvDescription.text = currentProduct.description

    }

    override fun getItemCount(): Int {
        return productList.size
    }
}