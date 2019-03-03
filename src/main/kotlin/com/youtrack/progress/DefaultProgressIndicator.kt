package com.youtrack.progress

import java.awt.BorderLayout
import java.awt.Color
import java.awt.GridLayout
import javax.swing.*

class DefaultProgressIndicator(
    private var title: String,
    private var text: String,
    private var isIndeterminate: Boolean = false
) : ProgressIndicator {
    private var myIsCancellable = true
    private var myIsRunning = false
    private val myPanel = JPanel()
    private val myProgressIndicatorComponent = JProgressBar()
    private val myTitleComponent = JLabel(title)
    private val myCancelButton = JButton("Cancel")

    init {
        myPanel.layout = GridLayout(2, 1)
        myPanel.add(myTitleComponent)
        val innerPanel = JPanel()
        innerPanel.layout = BorderLayout()
        innerPanel.add(myProgressIndicatorComponent, BorderLayout.CENTER)
        innerPanel.add(myCancelButton, BorderLayout.EAST)
        myPanel.add(innerPanel)

        myCancelButton.addActionListener {
            if (myIsCancellable) {
                myProgressIndicatorComponent.invalidate()
                myIsRunning = false
            }
        }
    }

    override fun setTitle(title: String) {
        this.title = title
    }

    override fun getTitle(): String = title

    override fun setText(text: String) {
        this.text = text
    }

    override fun getText(): String = text

    override fun isIndeterminate(): Boolean = isIndeterminate

    override fun setIndeterminate(isIndeterminate: Boolean) {
        this.isIndeterminate = isIndeterminate
    }

    override fun setCancellable(isCancellable: Boolean) {
        myIsCancellable = isCancellable
    }

    override fun isCancellable(): Boolean = myIsCancellable

    override fun isCancelled(): Boolean = !myIsRunning

    override fun isRunning(): Boolean = myIsRunning

    override fun start() {
        if (isRunning()) stop()

        val frame = JFrame()
        frame.run {
            myProgressIndicatorComponent.foreground = Color.BLACK
            add(myPanel)
            setSize(500, 100)
            defaultCloseOperation = JFrame.DISPOSE_ON_CLOSE
            isVisible = true
        }
    }

    private fun configureUI() {
        myProgressIndicatorComponent.isIndeterminate = isIndeterminate
    }

    override fun stop() {
    }
}