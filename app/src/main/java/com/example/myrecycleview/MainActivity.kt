package com.example.myrecycleview

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myrecycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),ProductAdapter.onItemClickListener {
    private lateinit var binding: ActivityMainBinding
    private val myProductList =listOf(Product("P001",2.50,"Ball Pen"),
        Product("P002",1.50,"Pencil"),
        Product("P003",1.00,"Book"),
        Product("P001",2.50,"Ball Pen"),
        Product("P002",1.50,"Pencil"),
        Product("P003",1.00,"Book"),
        Product("P001",2.50,"Ball Pen"),
        Product("P002",1.50,"Pencil"),
        Product("P003",1.00,"Book"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.productRecycleView.adapter = ProductAdapter(myProductList,this)
        binding.productRecycleView.layoutManager = LinearLayoutManager(application)
        binding.productRecycleView.setHasFixedSize(true)
    }

    override fun itemClick(position: Int) {
        Toast.makeText(application,myProductList[position].description,Toast.LENGTH_LONG).show()
    }
}