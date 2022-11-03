package com.example.gradlekotlintest.utils

import java.math.BigDecimal


fun secondsIntoDate(duration: BigDecimal): String {
    val longVal: Long = duration.longValueExact()
    val hours = longVal.toInt() / 3600
    var remainder = longVal.toInt() - hours * 3600
    val minutes = remainder / 60
    remainder -= minutes * 60
    val secs = remainder
    return "${addZero(hours)}:${addZero(minutes)}:${addZero(secs)}"
}

fun addZero(int: Int): String {
    return if (int < 10) "0$int" else int.toString()
}
