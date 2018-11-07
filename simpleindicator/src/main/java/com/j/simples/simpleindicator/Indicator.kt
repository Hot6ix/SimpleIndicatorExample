package com.j.simples.simpleindicator

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout

class Indicator: LinearLayout {

    private var mSelected = 0
    private var mIndicatorCount = 0
    private var mIndicatorRadius = 0
    private var mIndicatorColor = 0
    private var mIndicatorSelectedColor = 0
    private var mIndicatorSpaceBetween = 0
    private var mIndicatorStrokeWidth = 0
    private var mIndicatorStrokeColor = 0

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet): super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet) {
        if(isInEditMode) return

        context.theme.obtainStyledAttributes(attrs, R.styleable.Indicator, 0, 0).apply {
            try {
                mSelected = getInteger(R.styleable.Indicator_selected, 0)
                mIndicatorCount = getInteger(R.styleable.Indicator_indicatorCount, 0)
                mIndicatorRadius = getDimension(R.styleable.Indicator_indicatorRadius, resources.getDimension(R.dimen.indicatorSize)).toInt()
                mIndicatorColor = getInteger(R.styleable.Indicator_indicatorColor, ContextCompat.getColor(context, R.color.indicator))
                mIndicatorSelectedColor = getInteger(R.styleable.Indicator_indicatorSelectedColor, ContextCompat.getColor(context, R.color.indicator_selected))
                mIndicatorSpaceBetween = getDimension(R.styleable.Indicator_indicatorSpaceBetween, resources.getDimension(R.dimen.indicatorSpaceBetween)).toInt()
                mIndicatorStrokeWidth = getDimension(R.styleable.Indicator_indicatorStrokeWidth, 0f).toInt()
                mIndicatorStrokeColor = getColor(R.styleable.Indicator_indicatorStrokeColor, 0)
            } finally {
                recycle()
            }
        }

        for(index in 0 until mIndicatorCount) {
            val view = View(context)
            val layoutParams = LayoutParams(mIndicatorRadius, mIndicatorRadius)

            if(index < mIndicatorCount - 1) {
                layoutParams.rightMargin = mIndicatorSpaceBetween
            }
            view.layoutParams = layoutParams

            changeIndicatorColor(view, index)

            addView(view)
        }
    }

    private fun changeIndicatorColor(view: View, index: Int) {
        val gradientDrawable = GradientDrawable().apply {
            shape = GradientDrawable.OVAL
            setStroke(mIndicatorStrokeWidth, mIndicatorStrokeColor)
        }

        if(index == mSelected) {
            gradientDrawable.setColor(mIndicatorSelectedColor)
        }
        else {
            gradientDrawable.setColor(mIndicatorColor)
        }
        view.background = gradientDrawable
    }

    fun next() {
        if(mSelected < mIndicatorCount-1) {
            mSelected++
            for(index in 0 until mIndicatorCount) {
                val view = getChildAt(index)
                changeIndicatorColor(view, index)
            }
        }
    }

    fun prev() {
        if(mSelected > 0) {
            mSelected--
            for(index in 0 until mIndicatorCount) {
                val view = getChildAt(index)
                changeIndicatorColor(view, index)
            }
        }
    }

    fun select(index: Int): Boolean {
        if(index < 0 || index > mIndicatorCount-1) return false

        mSelected = index
        for(index in 0 until mIndicatorCount) {
            val view = getChildAt(index)
            changeIndicatorColor(view, index)
        }
        return true
    }

    fun getCurrentSelected() = mSelected

    fun getIndicatorCount() = mIndicatorCount

}