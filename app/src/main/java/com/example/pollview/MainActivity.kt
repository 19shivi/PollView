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
        var temp = ArrayList<String>()
        temp.add("welkjl;jgeoihfe b'yiov'yvnoi tybvee6yoiu;kerh;lkgrghl bikvbhi /bljgrkk;he ilkh ibejrlh bkler")
        temp.add("CPkjewfvboiperu;yevoirgyerboigerhbvoguewgoirgb;iowhvnoeriygbhrguhelkgjrh oi;vewrhbivlkhrlkkhtb;lgtr P")
        temp.add("kiu23bnevurievb3piutrnhugtehy ur vpt8ioy nu9pvp3ny9 8pon5y54tp9o54b pon8ptvp8yp8ov5ni4y;8vn54 y8 ntv8oyhgot45;uyvbutgvhno5iuoi;vytyvbo54iuyo vni4;5ut ybo54iutvbo8pyyppo8n;il reuligvbnlt.wehr wungv")
        temp.add("wqekul ifv ilerugqvtiupv t3r4 rbgvto[8yerp9q[oiurei; byuunv;ileur ivbervreyoiu;ytio;eurtvbty;oieru;iouerhtiyberoytb;ioeryvb rehtnivu[ oerioytgbvyubgeroih'hoitjb'igooir vr ")
        temp.add("welkjl;jgeoihfe b'yiov'yvnoi tybvee6yoiu;kerh;lkgrghl bikvbhi /bljgrkk;he ilkh ibejrlh bkler")
        temp.add("CPkjewfvboiperu;yevoirgyerboigerhbvoguewgoirgb;iowhvnoeriygbhrguhelkgjrh oi;vewrhbivlkhrlkkhtb;lgtr P")
        temp.add("kiu23bnevurievb3piutrnhugtehy ur vpt8ioy nu9pvp3ny9 8pon5y54tp9o54b pon8ptvp8yp8ov5ni4y;8vn54 y8 ntv8oyhgot45;uyvbutgvhno5iuoi;vytyvbo54iuyo vni4;5ut ybo54iutvbo8pyyppo8n;il reuligvbnlt.wehr wungv")
        temp.add("wqekul ifv ilerugqvtiupv t3r4 rbgvto[8yerp9q[oiurei; byuunv;ileur ivbervreyoiu;ytio;eurtvbty;oieru;iouerhtiyberoytb;ioeryvb rehtnivu[ oerioytgbvyubgeroih'hoitjb'igooir vr ")

        var count = ArrayList<Int>()
        count.add(170)
        count.add(150)
        count.add(100)
        count.add(70)
        count.add(170)
        count.add(150)
        count.add(100)
        count.add(70)


        mainBinding.set.setOnClickListener {
            mainBinding.pollView.setQuestion("wejhgfvyj4 ycjelkfgvuilvi y4ti4iut gi4utg iuvt4g vuigt4ui45 tv5t v4 h lurvybg3yu4tvb487")
            mainBinding.pollView.setOptions(temp, count)
           /* mainBinding.pollView.questionTextView?.textSize=20f
            mainBinding.pollView.optionViews.forEach {
                it.tvOption.textSize=20f
                it.tvPercent.textSize=20f
            }*/
        }

        mainBinding.pollView.setOnOptionCLickListener(object : OnOptionClickListener {
            override fun onOptionClick(position: Int) {
               Log.v("pollview",position.toString())
            }
        })

    }
}