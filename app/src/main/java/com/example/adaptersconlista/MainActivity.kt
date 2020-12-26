package com.example.adaptersconlista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adaptersconlista.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter : StringAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createRecyclerView()
    }

    private fun createRecyclerView() {
        var num= Random.nextInt(5)+5
        var mutableList = mutableListOf<String>()
        for(i in 1..num){
            mutableList.add("Elemento$i")
        }
        val listaString = mutableList
        adapter = StringAdapter(listaString.toMutableList())
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = adapter
    }

}