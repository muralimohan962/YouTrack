package com.youtrack.progress

interface ProgressIndicator {

    fun setTitle(title: String)

    fun getTitle(): String

    fun setText(text: String)

    fun getText(): String

    fun isIndeterminate(): Boolean

    fun setIndeterminate(isIndeterminate: Boolean)

    fun setCancellable(isCancellable: Boolean)

    fun isCancellable(): Boolean

    fun isCancelled(): Boolean

    fun isRunning(): Boolean

    fun start()

    fun stop()
}