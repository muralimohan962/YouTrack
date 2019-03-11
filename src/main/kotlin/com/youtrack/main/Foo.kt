package com.youtrack.main

import com.youtrack.ui.MyPanel
import com.youtrack.ui.initUI
import javax.swing.JFrame

fun foo() {

    initUI()
    val component = MyPanel()

    val frame = JFrame()
    frame.run {
        add(component)
        setSize(500, 500)
        defaultCloseOperation = JFrame.DISPOSE_ON_CLOSE
        isVisible = true
    }
}