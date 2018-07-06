package com.project.amplink.testproject.util

import android.content.Context
import android.widget.Toast


fun Context.toast(text:String, duration :Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this,text, duration).show()
}