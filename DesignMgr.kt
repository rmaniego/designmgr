package com.ripelemon.ripelemon.designmgr

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView

class DesignMgr {
    companion object {
        // attributes
        fun visibility(view: View, show: Boolean) {
            view.visibility = View.GONE
            if (show) view.visibility = View.VISIBLE
        }
        fun enable(view: TextView, enabled: Boolean) {
            view.setTextColor(colors("silver"))
            if (enabled) view.setTextColor(colors("unblue"))
        }
        // process
        fun removeAllViews(views: ArrayList<ViewGroup>) {
            for (view in views) view.removeAllViews()
        }
        fun addToView(layout: ViewGroup, views: ArrayList<View>) {
            for (view in views) layout.addView(view)
        }
        fun addTextFields(layout: ViewGroup, views: ArrayList<EditText>) {
            for (view in views) layout.addView(view)
        }
        // utils
        fun colors(color: String): Int {
            if (color == "primary") return Color.parseColor("#ff559be9")
            if (color == "secondary") return Color.parseColor("#fffafafa")
            if (color == "accent") return Color.parseColor("#fffafafa")

            if (color == "error") return Color.parseColor("#fff44336")
            if (color == "status") return Color.parseColor("#ff2196f3")
            if (color == "success") return Color.parseColor("#ff4caf50")
            if (color == "warning") return Color.parseColor("#ffff9800")

            if (color == "unblue") return Color.parseColor("#ff559be9")
            if (color == "bluejeans") return Color.parseColor("#ff55a6ff")
            if (color == "icterine") return Color.parseColor("#fffff35f")
            if (color == "lightsalmon") return Color.parseColor("#ffff927d")
            if (color == "blackcoral") return Color.parseColor("#ff54596e")
            if (color == "aliceblue") return Color.parseColor("#ffe3f2fd")
            if (color == "cinnabar") return Color.parseColor("#ffe53935")
            if (color == "fern") return Color.parseColor("#ff66bb6a")

            if (color == "white") return Color.parseColor("#ffffffff")
            if (color == "silver") return Color.parseColor("#ffbdbdbd")
            if (color == "gray") return Color.parseColor("#ff757575")
            if (color == "dimgray") return Color.parseColor("#ff616161")
            if (color == "charcoal") return Color.parseColor("#ff424242")
            if (color == "nero") return Color.parseColor("#ff212121")
            return Color.parseColor("#ff000000")
        }
    }
}