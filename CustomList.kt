package com.ripelemon.ripelemon.designmgr

import android.content.Context
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ListView
import kotlin.math.roundToInt

class CustomList(context: Context) {

    var context = context

    // initialize
    private var element: ListView? = null
    init {
        element = ListView(context)
    }

    fun build(): ListView {
        // v1.0.0-201911180240
        // v1.0.0-202005090025
        return element!!
    }

    fun layout(width: Any, height: Any): CustomList {
        var params: ViewGroup.LayoutParams = element!!.layoutParams as LinearLayout.LayoutParams
        // check width data type
        if (width is String) params.width = layoutParams(width)
        if (width is Int) params.width = pixel(width)
        // check height data type
        if (height is String) params.height = layoutParams(height)
        if (height is Int) params.height = pixel(height)
        element!!.layoutParams = params
        return this
    }

    fun margin(top: Int, right: Int, bottom: Int, left: Int): CustomList {
        var params: LinearLayout.LayoutParams = element!!.layoutParams as LinearLayout.LayoutParams
        params.setMargins(top, right, bottom, left)
        element!!.layoutParams = params
        return this
    }

    fun elevation(dip: Int): CustomList {
        element!!.elevation = displayValue(dip)
        return this
    }

    fun backgroundColor(color: Int): CustomList {
        element!!.setBackgroundColor(color)
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