package com.ripelemon.ripelemon.designmgr

import android.content.Context
import android.text.InputFilter
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlin.math.roundToInt

open class CustomLayout(var context: Context) {

    var element = LinearLayout(context)
    init {
        element.id = View.generateViewId()
    }

    fun id(): Int {
        return element.id
    }

    fun build(): LinearLayout {
        // v1.0.0-201911180240
        // v1.0.0-202005090025
        return element
    }

    fun attachToParent(layout: ViewGroup): Int {
        layout.addView(element)
        return element.id
    }

    fun layout(width: Any, height: Any): CustomLayout {
        val params = LinearLayout.LayoutParams(layoutParams("wrapContent"), layoutParams("wrapContent"))
        params.width = if (width is String) layoutParams(width) else pixel(width as Int)
        params.height = if (height is String) layoutParams(height) else pixel(height as Int)
        element.layoutParams = params
        return this
    }

    fun margin(left: Int, top: Int, right: Int, bottom: Int): CustomLayout {
        val params = LinearLayout.LayoutParams(element.layoutParams.width, element.layoutParams.height)
        params.setMargins(left, top, right, bottom)
        element.layoutParams = params
        return this
    }

    fun padding(left: Int, top: Int, right: Int, bottom: Int): CustomLayout {
        element.setPadding(left, top, right, bottom)
        return this
    }

    fun orientation(value: String): CustomLayout {
        element.orientation = orientations(value)
        return this
    }

    fun gravity(value: String): CustomLayout {
        element.gravity = gravities(value)
        return this
    }

    fun elevation(dip: Int): CustomLayout {
        element.elevation = displayValue(dip)
        return this
    }

    fun backgroundColor(color: Int): CustomLayout {
        element.setBackgroundColor(color)
        return this
    }

    fun visibility(show: Boolean): CustomLayout {
        element.visibility = View.GONE
        if (show) element.visibility = View.VISIBLE
        return this
    }

    // utils

    private fun layoutParams(value: String): Int {
        //v0.1.0-201911152336
        if (value == "matchParent") return LinearLayout.LayoutParams.MATCH_PARENT
        return LinearLayout.LayoutParams.WRAP_CONTENT
    }

    private fun orientations(value: String): Int {
        if (value == "horizontal") return LinearLayout.HORIZONTAL
        return LinearLayout.VERTICAL
    }

    private fun gravities(value: String): Int {
        if (value == "top") return Gravity.TOP
        if (value == "start") return Gravity.START
        if (value == "center") return Gravity.CENTER
        if (value == "bottom") return Gravity.BOTTOM
        if (value == "end") return Gravity.END
        if (value == "top,start") return Gravity.TOP or Gravity.START
        if (value == "top,center") return Gravity.TOP or Gravity.CENTER_HORIZONTAL
        if (value == "top,end") return Gravity.TOP or Gravity.END
        if (value == "center,start") return Gravity.CENTER_VERTICAL or Gravity.START
        if (value == "center,center") return Gravity.CENTER_VERTICAL or Gravity.CENTER_HORIZONTAL
        if (value == "center,end") return Gravity.CENTER_VERTICAL or Gravity.END
        if (value == "bottom,start") return Gravity.BOTTOM or Gravity.START
        if (value == "bottom,center") return Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
        if (value == "bottom,end") return Gravity.BOTTOM or Gravity.END
        return Gravity.NO_GRAVITY
    }

    private fun displayValue(dip: Int): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip.toFloat(), context.resources.displayMetrics)
    }

    private fun pixel(dip: Int): Int {
        return displayValue(dip).roundToInt()
    }
}