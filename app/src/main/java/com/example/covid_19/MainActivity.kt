package com.example.covid_19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var modelList = arrayListOf<Model>(
            Model("a", "b"),
            Model("c", "d")
        )

        val mAdapter = MainRvAdapter(this, modelList)
        mRecyclerView.adapter = mAdapter

        /*val la = LinearLayoutManager(this)
        mRecyclerView.layoutManager = la*/

        mRecyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
        }
    }
}
