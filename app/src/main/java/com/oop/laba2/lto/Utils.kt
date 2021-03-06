package com.oop.laba2.lto

import android.content.res.Resources

object Utils {
    val Int.dp: Int
        get() = (this / Resources.getSystem().displayMetrics.density).toInt()

    val Int.px: Int
        get() = (this * Resources.getSystem().displayMetrics.density).toInt()
}