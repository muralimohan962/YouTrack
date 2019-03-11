package com.youtrack.ui

import java.awt.Color
import java.awt.Font
import javax.swing.UIManager

fun initUI() {
    UIManager.put("Button.background", Color.decode("#444A4D"))
    UIManager.put("Button.foreground", Color.WHITE)
    UIManager.put("Checkbox.background", Color.decode("#444A4D"))
    UIManager.put("Checkbox.foreground", Color.WHITE)
    UIManager.put("Panel.background", Color.decode("#42474B"))
    UIManager.put("Label.foreground", Color.WHITE)
    UIManager.put("Label.background", Color.decode("#42474B"))
    UIManager.put("Checkbox.foreground", Color.WHITE)
    UIManager.put("Checkbox.background", Color.decode("#444A4D"))
    UIManager.put("Checkbox.select", Color.GREEN)
    UIManager.put("TextField.font", Font(Font.SERIF, Font.PLAIN, 18))
    UIManager.put("PasswordField.font", Font(Font.SERIF, Font.PLAIN, 18))
    UIManager.put("TextArea.font", Font(Font.SERIF, Font.PLAIN, 18))
}