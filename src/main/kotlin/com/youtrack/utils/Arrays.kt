package com.youtrack.utils

fun <T> Array<T>.asWhole(): String {
    val builder = StringBuilder()
    forEach { builder.append(it.toString()) }
    return builder.toString()
}