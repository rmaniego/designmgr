package com.ripelemon.ripelemon.designmgr

import android.content.Context
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import kotlin.math.roundToInt

class CustomLayout(context: Context) {

    var context = context

    // initialize
    private var element: LinearLayout? = null
    init {
        element = LinearLayout(context)
        element!!.id = View.generateViewId()
    }

    fun id(): Int {
        return element!!.id
    }

    fun build(): LinearLayout {
        // v1.0.0-201911180240
        // v1.0.0-202005090025
        return element!!
    }

    fun layout(width: Any, height: Any): CustomLayout {
        var params: LinearLayout.LayoutParams = element!!.layoutParams as LinearLayout.LayoutParams
        // check width data type
        if (width is String) params.width = layoutParams(width)
        if (width is Int) params.width = pixel(width)
        // check height data type
        if (height is String) params.height = layoutParams(height)
        if (height is Int) params.height = pixel(height)
        element!!.layoutParams = params
        return this
    }

    fun margin(left: Int, top: Int, right: Int, bottom: Int): CustomLayout {
        var params: LinearLayout.LayoutParams = element!!.layoutParams as LinearLayout.LayoutParams
        params.setMargins(left, top, right, bottom)
        element!!.layoutParams = params
        return this
    }

    fun padding(left: Int, top: Int, right: Int, bottom: Int): CustomLayout {
        element!!.setPadding(left, top, right, bottom)
        return this
    }

    fun orientation(value: String): CustomLayout {
        element!!.orientation = orientations(value)
        return this
    }

    fun gravity(value: String): CustomLayout {
        element!!.gravity = gravities(value)
        return this
    }

    fun elevation(dip: Int): CustomLayout {
        element!!.elevation = displayValue(dip)
        return this
    }

    fun backgroundColor(color: Int): CustomLayout {
        element!!.setBackgroundColor(color)
        return this
    }

    fun visibility(show: Boolean): CustomLayout {
        element!!.visibility = View.GONE
        if (show) element!!.visibility = View.VISIBLE
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