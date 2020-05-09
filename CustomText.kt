package com.ripelemon.ripelemon.designmgr

import android.content.Context
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import kotlin.math.roundToInt

open class CustomText(var context: Context) {

    private var element = TextView(context)
    init {
        element.id = View.generateViewId()
    }

    fun id(): Int {
        return element.id
    }

    fun build(): TextView {
        // v1.0.0-201911180240
        // v1.0.0-202005090025
        return element
    }

    fun layout(width: Any, height: Any): CustomText {
        val params = LinearLayout.LayoutParams(layoutParams("wrapContent"), layoutParams("wrapContent"))
        params.width = if (width is String) layoutParams(width) else pixel(width as Int)
        params.height = if (height is String) layoutParams(height) else pixel(height as Int)
        element.layoutParams = params
        return this
    }

    fun margin(left: Int, top: Int, right: Int, bottom: Int): CustomText {
        val params = LinearLayout.LayoutParams(element.layoutParams.width, element.layoutParams.height)
        params.setMargins(left, top, right, bottom)
        element.layoutParams = params
        return this
    }

    fun padding(left: Int, top: Int, right: Int, bottom: Int): CustomText {
        element.setPadding(left, top, right, bottom)
        return this
    }

    fun alignment(value: String): CustomText {
        element.textAlignment = alignments(value)
        return this
    }

    fun gravity(value: String): CustomText {
        element.gravity = gravities(value)
        return this
    }

    fun elevation(dip: Int): CustomText {
        element.elevation = displayValue(dip)
        return this
    }

    fun backgroundColor(color: Int): CustomText {
        element.setBackgroundColor(color)
        return this
    }

    fun textColor(color: Int): CustomText {
        element.setTextColor(color)
        return this
    }

    fun textSize(dip: Int): CustomText {
        element.textSize = displayValue(dip)
        return this
    }

    fun text(value: String): CustomText {
        element.text = value
        return this
    }

    fun visibility(show: Boolean): CustomText {
        element.visibility = View.GONE
        if (show) element.visibility = View.VISIBLE
        return this
    }

    // shortcuts
    fun banner(): CustomText {
        element.textSize = displayValue(17)
        return this
    }
    fun headline(): CustomText {
        element.textSize = displayValue(12)
        return this
    }
    fun title(): CustomText {
        element.textSize = displayValue(10)
        return this
    }
    fun body(): CustomText {
        element.textSize = displayValue(8)
        return this
    }
    fun label(): CustomText {
        element.textSize = displayValue(7)
        return this
    }
    fun caption(): CustomText {
        element.textSize = displayValue(6)
        return this
    }
    fun overline(): CustomText {
        element.textSize = displayValue(5)
        return this
    }

    // utils
    private fun layoutParams(value: String): Int {
        //v0.1.0-201911152336
        if (value == "matchParent") return LinearLayout.LayoutParams.MATCH_PARENT
        return LinearLayout.LayoutParams.WRAP_CONTENT
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

    private fun alignments(value: String): Int {
        if (value == "start") return View.TEXT_ALIGNMENT_TEXT_START
        if (value == "center") return View.TEXT_ALIGNMENT_CENTER
        if (value == "end") return View.TEXT_ALIGNMENT_TEXT_END
        return View.TEXT_ALIGNMENT_TEXT_START
    }

    private fun displayValue(size: Int): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, size.toFloat(), context.resources.displayMetrics)
    }

    private fun pixel(size: Int): Int {
        return displayValue(size).roundToInt()
    }
}