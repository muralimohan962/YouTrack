package com.youtrack.text

import java.awt.Color
import java.awt.Font
import javax.swing.JComponent

data class TextAttributes(
    val backgroundColor: Color? = null,
    var foregroundColor: Color? = null,
    val font: Font? = null
) {


    companion object {
        private val FONT = Font(Font.DIALOG, Font.PLAIN, 18)
        private val TEXT_ATTRIBUTES = arrayListOf<TextAttributes>()
        private val DEFAULT_TEXT_ATTRIBUTES = TextAttributes(
            Color.WHITE,
            Color.GREEN.brighter(),
            Font(Font.MONOSPACED, Font.ITALIC, 18)
        )
        @JvmField
        val TITLE_TEXT_ATTRIBUTES = TextAttributes(
            foregroundColor = Color.decode("#226BFF").darker(),
            font = Font(Font.MONOSPACED, Font.PLAIN, 18)
        )

        @JvmField
        val STATE_TEXT_ATTRIBUTES = TextAttributes(foregroundColor = Color.decode("#49FF39").darker(), font = FONT)

        @JvmField
        val PRIORITY_TEXT_ATTRIBUTES = TextAttributes(foregroundColor = Color.ORANGE.darker(), font = FONT)

        @JvmField
        val ASSIGNEE_TEXT_ATTRIBUTES = TextAttributes(foregroundColor = Color.RED.darker(), font = FONT)

        @JvmField
        val FIX_VERSION__TEXT_ATTRIBUTES = TextAttributes(foregroundColor = Color.GREEN.darker(), font = FONT)

        @JvmField
        val SUBSYTEM_TEXT_ATTRIBUTES = TextAttributes(foregroundColor = Color.MAGENTA.darker(), font = FONT)

        @JvmStatic
        fun add(textAttributes: TextAttributes) {
            if (!TEXT_ATTRIBUTES.contains(textAttributes)) TEXT_ATTRIBUTES.add(textAttributes)
        }

        fun getTextAttributes(): TextAttributes =
            if (TEXT_ATTRIBUTES.isEmpty()) DEFAULT_TEXT_ATTRIBUTES else TEXT_ATTRIBUTES.first()

        @JvmStatic
        fun setAttribute(component: JComponent, attributes: TextAttributes) {
            component.isOpaque = true
            if (attributes.backgroundColor != null)
                component.background = Color(attributes.backgroundColor.red, attributes.backgroundColor.green, attributes.backgroundColor.blue, 150)
            component.foreground = attributes.foregroundColor
            component.font = attributes.font
        }
    }
}