package com.example.pollview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pollview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        var temp=ArrayList<String>()
        temp.add("JAVA")
        temp.add("CPP")
       temp.add("Python")
        temp.add("Python")
        var count=ArrayList<Int>()
        count.add(10)
        count.add(10)
       count.add(17)
        count.add(170)

        mainBinding.pollView.setOptions(temp,count)
        mainBinding.set.setOnClickListener {
            mainBinding.pollView.setOptions(temp,count)
        }

    }
}