package com.example.gradlekotlintest.utils

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast

fun Context.isNetworkAvailable() = try {
    (getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager)
        ?.activeNetworkInfo?.isConnectedOrConnecting
        ?: false
} catch (e: java.lang.Exception) {
    false
}

fun Context.toast(message: CharSequence) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()