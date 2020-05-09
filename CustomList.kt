package com.ripelemon.ripelemon.designmgr

import android.content.Context
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ListView
import kotlin.math.roundToInt

open class CustomList(var context: Context) {

    private var element = ListView(context)
    init {
        element.id = View.generateViewId()
    }

    fun id(): Int {
        return element.id
    }

    fun build(): ListView {
        // v1.0.0-201911180240
        // v1.0.0-202005090025
        return element
    }

    fun layout(width: Any, height: Any): CustomList {
        val params = LinearLayout.LayoutParams(layoutParams("wrapContent"), layoutParams("wrapContent"))
        params.width = if (width is String) layoutParams(width) else pixel(width as Int)
        params.height = if (height is String) layoutParams(height) else pixel(height as Int)
        element.layoutParams = params
        return this
    }

    fun margin(left: Int, top: Int, right: Int, bottom: Int): CustomList {
        val params = LinearLayout.LayoutParams(element.layoutParams.width, element.layoutParams.height)
        params.setMargins(left, top, right, bottom)
        element.layoutParams = params
        return this
    }

    fun padding(left: Int, top: Int, right: Int, bottom: Int): CustomList {
        element.setPadding(left, top, right, bottom)
        return this
    }

    fun elevation(dip: Int): CustomList {
        element.elevation = displayValue(dip)
        return this
    }

    fun backgroundColor(color: Int): CustomList {
        element.setBackgroundColor(color)
        return this
    }

    fun visibility(show: Boolean): CustomList {
        element.visibility = View.GONE
        if (show) element.visibility = View.VISIBLE
        return this
    }

    // utils
    private fun layoutParams(type: String): Int {
        //v0.1.0-201911152336
        if (type == "matchParent") return LinearLayout.LayoutParams.MATCH_PARENT
        return LinearLayout.LayoutParams.WRAP_CONTENT
    }

    private fun displayValue(dip: Int): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip.toFloat(), context.resources.displayMetrics)
    }

    private fun pixel(dip: Int): Int {
        return displayValue(dip).roundToInt()
    }
}