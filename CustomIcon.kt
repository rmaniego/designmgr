package com.ripelemon.ripelemon.designmgr

import android.content.Context
import android.graphics.BitmapFactory
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.graphics.drawable.RoundedBitmapDrawable
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import kotlin.math.roundToInt

class CustomIcon(context: Context) {
    var context = context

    // initialize
    private var element: ImageView? = null
    init {
        element = ImageView(context)
    }

    fun build(): ImageView {
        // v1.0.0-201911180240
        // v1.0.0-202005090025
        return element!!
    }

    fun layout(width: Any, height: Any): CustomIcon {
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

    fun margin(top: Int, right: Int, bottom: Int, left: Int): CustomIcon {
        var params: LinearLayout.LayoutParams = element!!.layoutParams as LinearLayout.LayoutParams
        params.setMargins(top, right, bottom, left)
        element!!.layoutParams = params
        return this
    }

    fun alignment(value: String): CustomIcon {
        element!!.textAlignment = alignments(value)
        return this
    }

    fun elevation(dip: Int): CustomIcon {
        element!!.elevation = displayValue(dip)
        return this
    }

    fun backgroundColor(color: Int): CustomIcon {
        element!!.setBackgroundColor(color)
        return this
    }

    fun icon(drawable: Int): CustomIcon {
        element!!.setImageDrawable(getImage(drawable))
        return this
    }

    // utils
    private fun layoutParams(value: String): Int {
        //v0.1.0-201911152336
        if (value == "matchParent") return LinearLayout.LayoutParams.MATCH_PARENT
        return LinearLayout.LayoutParams.WRAP_CONTENT
    }

    private fun alignments(value: String): Int {
        if (value == "start") return View.TEXT_ALIGNMENT_TEXT_START
        if (value == "center") return View.TEXT_ALIGNMENT_CENTER
        if (value == "end") return View.TEXT_ALIGNMENT_TEXT_END
        return View.TEXT_ALIGNMENT_TEXT_START
    }


    private fun getImage(drawable: Int): RoundedBitmapDrawable {
        return RoundedBitmapDrawableFactory.create(
            context.resources,
            BitmapFactory.decodeResource(context.resources, drawable))
    }

    private fun displayValue(dip: Int): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip.toFloat(), context.resources.displayMetrics)
    }

    private fun pixel(dip: Int): Int {
        return displayValue(dip).roundToInt()
    }
}