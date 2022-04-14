package project.ljy.kotlindemo.ui

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import project.ljy.kotlindemo.R
import project.ljy.kotlindemo.adapter.GridAdapter


class GridLayoutActivity : Activity() {

    private lateinit var gridLayout: GridLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_layout)

        var startTimeMill = System.currentTimeMillis()
        gridLayout = findViewById<GridLayout>(R.id.grid_layout)
        Log.d("GridLayoutActivity", "inflate gridLayout cost:${System.currentTimeMillis() - startTimeMill}")
        //测试recyclerView的绘制耗时
        val dataList = arrayListOf("1", "2", "3", "4", "5", "6")
        val gridRecyclerView = findViewById<RecyclerView>(R.id.grid_layout2)
        startTimeMill = System.currentTimeMillis()
        gridRecyclerView.adapter = GridAdapter(this, dataList)
        gridRecyclerView.layoutManager = GridLayoutManager(this, 4)
        Log.d("GridLayoutActivity", "inflate grid recyclerView cost:${System.currentTimeMillis() - startTimeMill}")
    }
}