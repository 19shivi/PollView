package com.shivam.pollview

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.DecelerateInterpolator
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding
import com.shivam.pollview.databinding.OptionViewBinding


@SuppressLint("ClickableViewAccessibility")
class PollView(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    LinearLayout(context, attrs, defStyleAttr) {
    constructor(context: Context, attrs: AttributeSet? = null) : this(
        context = context,
        attrs = attrs,
        defStyleAttr = 0
    )

    constructor(context: Context) : this(context = context, attrs = null, defStyleAttr = 0)

    private var mOptionClickListener: OnOptionClickListener? = null
    private var voteCountList = arrayListOf<Int>()
    private var percentList = arrayListOf<Int>()
    var optionViews = arrayListOf<OptionViewBinding>()
    var questionTextView: TextView? = null
    private var defaultDrawable: Drawable =
        ContextCompat.getDrawable(context, R.drawable.progress_track)!!
    private var selectedDrawable: Drawable =
        ContextCompat.getDrawable(context, R.drawable.progress_track_selected)!!


    fun setOnOptionCLickListener(onOptionClickListener: OnOptionClickListener) {
        this.mOptionClickListener = onOptionClickListener
    }

    fun getVoteCount(): ArrayList<Int> {
        return voteCountList
    }

    fun setQuestion(question: String) {
        orientation = VERTICAL
        questionTextView = TextView(context)
        questionTextView?.text = question
        questionTextView?.setPadding(64, 0, 64, 16)
        removeAllViews()
        addView(questionTextView)
    }

    fun setDefaultProgressDrawable(drawable: Drawable) {
        defaultDrawable = drawable
    }

    fun setSelectedProgressDrawable(drawable: Drawable) {
        selectedDrawable = drawable
    }

    fun setOptions(options: ArrayList<String>, initialCount: ArrayList<Int>) {

        voteCountList = initialCount
        optionViews.clear()
        var position = 0
        options.forEach {
            val optionViewBinding = OptionViewBinding.inflate(LayoutInflater.from(context))
            optionViewBinding.seekBar.progressDrawable =
                defaultDrawable.constantState?.newDrawable()?.mutate()
            optionViewBinding.seekBar.visibility = VISIBLE
            optionViewBinding.seekBar.progress = 0
            optionViewBinding.seekBar.setOnTouchListener { _, _ -> true }
            optionViewBinding.tvOption.text = it
            optionViewBinding.tvOption.gravity = Gravity.CENTER
            optionViewBinding.tvOption.setPadding(24)
            optionViewBinding.tvPercent.visibility = GONE
            optionViewBinding.tvOption.tag = position
            optionViewBinding.tvOption.setOnClickListener {
                disableClick()
                val pos = it.tag as Int
                voteCountList[pos]++
                optionViews[pos].seekBar.progressDrawable =
                    selectedDrawable.constantState?.newDrawable()?.mutate()
                setPercent()
                mOptionClickListener?.onOptionClick(pos)

            }
            var optionParams=LayoutParams(LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
            optionParams.setMargins(32,32,32,0)
            optionViewBinding.cornerView.layoutParams=optionParams
            optionViews.add(optionViewBinding)
            addView(optionViewBinding.root)
            position++

        }
        var totalTextView = TextView(context)
        var total = 0
        voteCountList.forEach {
            total += it
        }
        totalTextView.text = "Total votes: $total"
        totalTextView.setPadding(64, 32, 0, 0)
        addView(totalTextView)
    }


    private fun roundSumTo100(list: ArrayList<Int>): ArrayList<Int> {
        var total = 0
        list.forEach {
            total += it
        }
        var diff = 100 - total
        var temp = 0
        while (diff != 0) {
            list[temp]++
            diff--
            temp++
        }
        return list
    }

    private fun setPercent() {
        var total = 0.0
        voteCountList.forEach {
            total += it
        }
        percentList = ArrayList()
        voteCountList.forEach {
            percentList.add(((it / total) * 100).toInt())
        }

        percentList = roundSumTo100(percentList)

        val animator = ArrayList<ObjectAnimator>()
        var position = 0
        optionViews.forEach {
            it.seekBar.visibility = VISIBLE
            it.tvPercent.visibility = VISIBLE
            it.tvPercent.text = ("${percentList[position]}%")
            animator.add(
                ObjectAnimator.ofInt(
                    it.seekBar,
                    "progress",
                    100,
                    percentList[position]
                )
            )
            it.tvOption.gravity = Gravity.CENTER_VERTICAL
            position++
        }
        val collectionAnimatorSet = List(animator.size) { i -> animator[i] }
        val animatorSet = AnimatorSet()
        animatorSet.playTogether(collectionAnimatorSet)
        animatorSet.interpolator = DecelerateInterpolator()
        animatorSet.duration = 1000
        animatorSet.start()
    }

    private fun disableClick() {
        optionViews.forEach {
            it.tvOption.isClickable = false
        }
    }

}