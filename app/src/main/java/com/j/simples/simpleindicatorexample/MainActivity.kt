package com.j.simples.simpleindicatorexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nextBtn.setOnClickListener {
            indicator.next()
        }

        prevBtn.setOnClickListener {
            indicator.prev()
        }

        val adapter = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_dropdown_item, arrayListOf("1", "2", "3", "4"))
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        indicator.select(id.toInt())
    }
}
