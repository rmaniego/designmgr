package com.ripelemon.ripelemon.designmgr

import android.content.Context
import android.text.InputType
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import kotlin.math.roundToInt

class CustomInput(context: Context) {
    var context = context

    // initialize
    private var element: EditText? = null
    init {
        element = EditText(context)
    }

    fun build(): EditText {
        // v1.0.0-201911180240
        // v1.0.0-202005090025
        return element!!
    }

    fun layout(width: Any, height: Any): CustomInput {
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

    fun alignment(value: String): CustomInput {
        element!!.textAlignment = alignments(value)
        return this
    }

    fun gravity(value: String): CustomInput {
        element!!.gravity = gravities(value)
        return this
    }

    fun elevation(dip: Int): CustomInput {
        element!!.elevation = displayValue(dip)
        return this
    }

    fun backgroundColor(color: Int): CustomInput {
        element!!.setBackgroundColor(color)
        return this
    }

    fun textSize(dip: Int): CustomInput {
        element!!.setTextSize(TypedValue.COMPLEX_UNIT_PX, displayValue(dip))
        return this
    }

    fun inputType(type: String): CustomInput {
        element!!.inputType = inputTypes(type)
        return this
    }

    fun hint(value: String): CustomInput {
        element!!.hint = value
        return this
    }

    fun text(value: String): CustomInput {
        element!!.setText(value)
        return this
    }

    // shortcuts
    fun banner(): CustomInput {
        element!!.textSize = displayValue(34)
        return this
    }
    fun headline(): CustomInput {
        element!!.textSize = displayValue(24)
        return this
    }
    fun title(): CustomInput {
        element!!.textSize = displayValue(20)
        return this
    }
    fun body(): CustomInput {
        element!!.textSize = displayValue(16)
        return this
    }
    fun label(): CustomInput {
        element!!.textSize = displayValue(14)
        return this
    }
    fun caption(): CustomInput {
        element!!.textSize = displayValue(12)
        return this
    }
    fun overline(): CustomInput {
        element!!.textSize = displayValue(10)
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

    private fun gravities(value: String): Int {
        if (value == "top") return Gravity.TOP
        if (value == "start") return Gravity.START
        if (value == "center") return Gravity.CENTER
        if (value == "bottom") return Gravity.BOTTOM
        if (value == "end") return Gravity.END
        if (value == "top,start") return Gravity.TOP or Gravity.START
        if (value == "top,end") return Gravity.TOP or Gravity.END
        if (value == "center,start") return Gravity.CENTER_VERTICAL or Gravity.START
        if (value == "center,end") return Gravity.CENTER_VERTICAL or Gravity.END
        if (value == "bottom,start") return Gravity.BOTTOM or Gravity.START
        if (value == "bottom,end") return Gravity.BOTTOM or Gravity.END
        return Gravity.NO_GRAVITY
    }

    private fun inputTypes(type: String): Int {
        if (type == "numeric") return InputType.TYPE_CLASS_NUMBER
        if (type == "decimal") return InputType.TYPE_NUMBER_FLAG_DECIMAL
        if (type == "date") return InputType.TYPE_CLASS_DATETIME
        if (type == "email") return InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
        if (type == "password") return InputType.TYPE_TEXT_VARIATION_PASSWORD
        return InputType.TYPE_CLASS_TEXT
    }

    private fun displayValue(dip: Int): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip.toFloat(), context.resources.displayMetrics)
    }

    private fun pixel(dip: Int): Int {
        return displayValue(dip).roundToInt()
    }
}