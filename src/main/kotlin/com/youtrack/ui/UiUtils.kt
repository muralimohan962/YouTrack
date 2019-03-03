package com.youtrack.ui

import com.youtrack.ui.laf.YouTrackTheme
import java.awt.Color
import java.awt.Font
import javax.swing.UIManager
import javax.swing.plaf.metal.MetalLookAndFeel

fun init() {
    MetalLookAndFeel.setCurrentTheme(YouTrackTheme())
    UIManager.put("Button.background", Color.decode("#5E88ED").darker())
    UIManager.put("Button.opaque", true)
    UIManager.put("Button.foreground", Color.WHITE.brighter())
    UIManager.put("window", Color.BLACK)
//    UIManager.put("Panel.background", Color.decode("#42474B"))
    UIManager.put("Button.darkShadow", Color.PINK)
    UIManager.put("Button.select", Color.GRAY)
    UIManager.put("focus", Color.PINK)
    UIManager.put("Button.highlight", Color.PINK)
    UIManager.put("Focus.color", Color.PINK)
    UIManager.put("PasswordField.font", Font(Font.SANS_SERIF, Font.PLAIN, 18))
    UIManager.put("Button.focusPainted", false)
    UIManager.put("CheckBox.background", Color.decode("#0B69C5"))
    UIManager.put("Desktop.background", Color.decode("#42474B"))
    UIManager.put("Button.highlight", Color.WHITE)
    UIManager.put("Checkbox.select", Color.WHITE)
    UIManager.put("Label.foreground", Color.BLACK.darker())
    UIManager.put("CheckBox.foreground", Color.WHITE)
    UIManager.put("TextField.foreground", Color.BLUE)
    UIManager.put("TextField.highlight", Color.BLUE)
    UIManager.put("TextField.darkShadow", Color.BLUE)
    UIManager.put("CheckBox.focusPainted", false)
}