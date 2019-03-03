package com.youtrack.ui.laf

import javax.swing.plaf.ColorUIResource
import javax.swing.plaf.metal.DefaultMetalTheme

class YouTrackTheme : DefaultMetalTheme() {

    override fun getFocusColor(): ColorUIResource = YouTrackLookAndFeel.FOCUS_COLOR


}