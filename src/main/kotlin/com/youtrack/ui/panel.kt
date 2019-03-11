package com.youtrack.ui

import java.awt.BorderLayout
import java.awt.Font
import java.awt.LayoutManager
import javax.swing.BorderFactory
import javax.swing.JPanel

@JvmOverloads
inline fun panel(
    title: String? = null,
    layoutManager: LayoutManager = BorderLayout(),
    init: JPanel.() -> Unit
): JPanel =
    JPanel().apply {
        initComponent()
        if (title != null)
            border = BorderFactory.createTitledBorder(title)

        layout = layoutManager
        init()
    }

@JvmOverloads
inline fun nonOpaquePanel(
    title: String? = null,
    layoutManager: LayoutManager = BorderLayout(),
    crossinline init: JPanel.() -> Unit
): JPanel =
    object : JPanel() {

        init {
            initComponent()
            isOpaque = false
            if (title != null)
                border = BorderFactory.createTitledBorder(title)

            layout = layoutManager
            init()
        }

        override fun setOpaque(isOpaque: Boolean) {
            super.setOpaque(false)
        }
    }

fun JPanel.initComponent() {
    font = Font(Font.DIALOG, Font.PLAIN, 18)
}