package com.youtrack.ui.laf

import java.awt.Color
import javax.swing.UIDefaults
import javax.swing.plaf.ColorUIResource
import javax.swing.plaf.metal.MetalLookAndFeel

class YouTrackLookAndFeel : MetalLookAndFeel() {

    override fun getDefaults(): UIDefaults {
        return super.getDefaults().apply {
            put("text", TEXT_COLOR)
            put("focus", FOCUS_COLOR)
            put("foreground", FOREGROUND_COLOR)
            put("desktop", DESKTOP_COLOR)
            put("background", BACKGROUND_COLOR)
        }
    }

    companion object {
        val TEXT_COLOR = ColorUIResource(Color.WHITE)
        val FOCUS_COLOR = ColorUIResource(Color.decode("#49AFFF"))
        val BACKGROUND_COLOR = ColorUIResource(Color.decode("#42474B"))
        val FOREGROUND_COLOR = ColorUIResource(Color.WHITE)
        val DESKTOP_COLOR = ColorUIResource(Color.decode("#373A3E"))
    }
}

