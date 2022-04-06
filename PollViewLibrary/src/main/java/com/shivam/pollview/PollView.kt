package com.shivam.pollview

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.animation.DecelerateInterpolator
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.shivam.pollview.databinding.PollViewBinding


@SuppressLint("ClickableViewAccessibility")
class PollView(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    LinearLayout(context, attrs, defStyleAttr) {
    constructor(context: Context, attrs: AttributeSet? = null) : this(
        context = context,
        attrs = attrs,
        defStyleAttr = 0
    )

    constructor(context: Context) : this(context = context, attrs = null, defStyleAttr = 0)

    var pollViewBinding: PollViewBinding
    private var options = arrayListOf<String>()
    private var percentage = arrayListOf<Int>()
    private var defaultDrawable: Drawable =
        ContextCompat.getDrawable(context, R.drawable.progress_track)!!
    private var selectedDrawable: Drawable =
        ContextCompat.getDrawable(context, R.drawable.progress_track_selected)!!

    init {
        val inflater = LayoutInflater.from(context)
        pollViewBinding = PollViewBinding.inflate(inflater, this, true)
        pollViewBinding.seekBar1.setOnTouchListener { _, _ -> true }
        pollViewBinding.seekBar2.setOnTouchListener { _, _ -> true }
        pollViewBinding.seekBar3.setOnTouchListener { _, _ -> true }
        pollViewBinding.seekBar4.setOnTouchListener { _, _ -> true }
        setListeners()
    }

    fun setQuestion(question: String) {
        pollViewBinding.questionTxt.text = question
    }

    fun setDefaultProgressDrawable(drawable: Drawable) {
        defaultDrawable = drawable
    }

    fun setSelectedProgressDrawable(drawable: Drawable) {
        selectedDrawable = drawable
    }

    fun setOptions(array: ArrayList<String>, initialCount: ArrayList<Int>) {
        options = array
        percentage = initialCount
        with(pollViewBinding)
        {
            tvOption1.isClickable = true
            tvOption2.isClickable = true
            tvOption3.isClickable = true
            tvOption4.isClickable = true
        }
        if (array.size > 0) {
            pollViewBinding.seekBar1.progressDrawable =
                defaultDrawable
            pollViewBinding.seekBar1.visibility = VISIBLE
            pollViewBinding.seekBar1.progress = 0
            pollViewBinding.tvOption1.text = array[0]
            pollViewBinding.tvOption1.gravity = Gravity.CENTER
            pollViewBinding.tvOption1.setPadding(0, 0, 0, 0)
            pollViewBinding.tvPercent1.visibility = GONE
        } else {
            with(pollViewBinding)
            {
                tvOption1.visibility = GONE
                tvPercent1.visibility = GONE
                seekBar1.visibility = GONE
            }
        }

        if (array.size > 1) {
            pollViewBinding.seekBar2.progressDrawable =
                defaultDrawable
            pollViewBinding.seekBar2.visibility = VISIBLE
            pollViewBinding.seekBar2.progress = 0
            pollViewBinding.tvOption2.text = array[1]
            pollViewBinding.tvOption2.gravity = Gravity.CENTER
            pollViewBinding.tvOption2.setPadding(0, 0, 0, 0)
            pollViewBinding.tvPercent2.visibility = GONE
        } else {
            with(pollViewBinding)
            {
                tvOption2.visibility = GONE
                tvPercent2.visibility = GONE
                seekBar2.visibility = GONE
            }
        }
        if (array.size > 2) {
            pollViewBinding.seekBar3.progressDrawable =
                defaultDrawable
            pollViewBinding.seekBar3.visibility = VISIBLE
            pollViewBinding.seekBar3.progress = 0
            pollViewBinding.tvOption3.text = array[2]
            pollViewBinding.tvOption3.setPadding(0, 0, 0, 0)
            pollViewBinding.tvOption3.gravity = Gravity.CENTER
            pollViewBinding.tvPercent3.visibility = GONE
        } else {
            with(pollViewBinding)
            {
                tvOption3.visibility = GONE
                tvPercent3.visibility = GONE
                seekBar3.visibility = GONE
            }
        }
        if (array.size > 3) {
            pollViewBinding.seekBar4.progressDrawable = defaultDrawable
            pollViewBinding.seekBar4.visibility = VISIBLE
            pollViewBinding.seekBar4.progress = 0
            pollViewBinding.tvOption4.setPadding(0, 0, 0, 0)
            pollViewBinding.tvOption4.text = array[3]
            pollViewBinding.tvOption4.gravity = Gravity.CENTER
            pollViewBinding.tvPercent4.visibility = GONE
        } else {
            with(pollViewBinding)
            {
                tvOption4.visibility = GONE
                tvPercent4.visibility = GONE
                seekBar4.visibility = GONE
            }
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    fun setListeners() {

        pollViewBinding.tvOption1.setOnClickListener {
            disableClick()
            percentage[0]++
            pollViewBinding.seekBar1.progressDrawable = selectedDrawable.constantState?.newDrawable()?.mutate()
            pollViewBinding.seekBar2.progressDrawable = defaultDrawable.constantState?.newDrawable()?.mutate()
            pollViewBinding.seekBar3.progressDrawable = defaultDrawable.constantState?.newDrawable()?.mutate()
            pollViewBinding.seekBar4.progressDrawable = defaultDrawable.constantState?.newDrawable()?.mutate()
            setPercent()
        }
        pollViewBinding.tvOption2.setOnClickListener {
            disableClick()
            percentage[1]++
            pollViewBinding.seekBar2.progressDrawable = selectedDrawable.constantState?.newDrawable()?.mutate()
            pollViewBinding.seekBar1.progressDrawable = defaultDrawable.constantState?.newDrawable()?.mutate()
            pollViewBinding.seekBar3.progressDrawable = defaultDrawable.constantState?.newDrawable()?.mutate()
            pollViewBinding.seekBar4.progressDrawable = defaultDrawable.constantState?.newDrawable()?.mutate()
            setPercent()
        }
        pollViewBinding.tvOption3.setOnClickListener {
            disableClick()
            percentage[2]++
            pollViewBinding.seekBar3.progressDrawable = selectedDrawable.constantState?.newDrawable()?.mutate()
            pollViewBinding.seekBar2.progressDrawable = defaultDrawable.constantState?.newDrawable()?.mutate()
            pollViewBinding.seekBar1.progressDrawable = defaultDrawable.constantState?.newDrawable()?.mutate()
            pollViewBinding.seekBar4.progressDrawable = defaultDrawable.constantState?.newDrawable()?.mutate()
            setPercent()
        }
        pollViewBinding.tvOption4.setOnClickListener {
            disableClick()
            percentage[3]++
            pollViewBinding.seekBar4.progressDrawable = selectedDrawable.constantState?.newDrawable()?.mutate()
            pollViewBinding.seekBar2.progressDrawable = defaultDrawable.constantState?.newDrawable()?.mutate()
            pollViewBinding.seekBar3.progressDrawable = defaultDrawable.constantState?.newDrawable()?.mutate()
            pollViewBinding.seekBar1.progressDrawable = defaultDrawable.constantState?.newDrawable()?.mutate()
            setPercent()
        }

    }

    private fun round100(list: ArrayList<Int>): ArrayList<Int> {
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
        percentage.forEach {
            total += it
        }
        var percent = ArrayList<Int>()
        percentage.forEach {
            percent.add(((it / total) * 100).toInt())
        }

        percent = round100(percent)


        val animator=ArrayList<ObjectAnimator>()
        if (percentage.size > 0) {
            pollViewBinding.seekBar1.visibility = VISIBLE
            pollViewBinding.tvPercent1.visibility = VISIBLE
            pollViewBinding.tvPercent1.text = ("${percent[0]}%")
            animator.add(ObjectAnimator.ofInt(pollViewBinding.seekBar1, "progress", 100, percent[0]))
            pollViewBinding.tvOption1.gravity = Gravity.CENTER_VERTICAL
            pollViewBinding.tvOption1.setPadding(64, 0, 0, 0)
        }
        if (percentage.size > 1) {
            pollViewBinding.seekBar2.visibility = VISIBLE
            pollViewBinding.tvPercent2.visibility = VISIBLE
            animator.add(ObjectAnimator.ofInt(pollViewBinding.seekBar2, "progress", 100, percent[1]))
            pollViewBinding.tvPercent2.text = ("${percent[1]}%")
            pollViewBinding.tvOption2.gravity = Gravity.CENTER_VERTICAL
            pollViewBinding.tvOption2.setPadding(64, 0, 0, 0)
        }
        if (percentage.size > 2) {
            pollViewBinding.seekBar3.visibility = VISIBLE
            pollViewBinding.tvPercent3.visibility = VISIBLE
            animator.add(ObjectAnimator.ofInt(pollViewBinding.seekBar3, "progress", 100, percent[2]))
            pollViewBinding.tvPercent3.text = ("${percent[2]}%")
            pollViewBinding.tvOption3.gravity = Gravity.CENTER_VERTICAL
            pollViewBinding.tvOption3.setPadding(64, 0, 0, 0)

        }
        if (percentage.size > 3) {
            pollViewBinding.seekBar4.visibility = VISIBLE
            pollViewBinding.tvPercent4.visibility = VISIBLE
            animator.add(ObjectAnimator.ofInt(pollViewBinding.seekBar4, "progress", 100, percent[3]))
            pollViewBinding.tvPercent4.text = ("${percent[3]}%")
            pollViewBinding.tvOption4.gravity = Gravity.CENTER_VERTICAL
            pollViewBinding.tvOption4.setPadding(64, 0, 0, 0)

        }
        val collectionAnimatorSet= List(animator.size){i->animator[i]}
        val animatorSet=AnimatorSet()
        animatorSet.playTogether(collectionAnimatorSet)
        animatorSet.interpolator = DecelerateInterpolator()
        animatorSet.duration = 1000
        animatorSet.start()
    }

    private fun disableClick() {
        with(pollViewBinding)
        {
            tvOption1.isClickable = false
            tvOption2.isClickable = false
            tvOption3.isClickable = false
            tvOption4.isClickable = false
        }
    }

}