package com.example.pollview

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.pollview.databinding.ActivityMainBinding
import com.shivam.pollview.OnOptionClickListener

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        val temp = ArrayList<String>()
        temp.add("Java")
        temp.add("Php")
        temp.add("Cpp")
        temp.add("Python")
        val count = ArrayList<Int>()
        count.add(170)
        count.add(150)
        count.add(100)
        count.add(70)




        mainBinding.set.setOnClickListener {
            mainBinding.pollView.setQuestion("Which is your favourite language")
            mainBinding.pollView.setOptions(temp, count)
            mainBinding.pollView.questionTextView?.textSize = 20f
            mainBinding.pollView.optionViews.forEach {
                it.tvOption.textSize = 20f
                it.tvPercent.textSize = 20f
                it.seekBar
            }
        }

        mainBinding.pollView.setOnOptionCLickListener(object : OnOptionClickListener {
            override fun onOptionClick(position: Int) {
                Log.v("pollview", position.toString())
            }
        })

    }
}