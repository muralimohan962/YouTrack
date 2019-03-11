package com.youtrack.utils

import java.util.*
import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

fun sendMail(sender: String, password: String, receiver: String, subject: String, content: String): Boolean {

    val properties = Properties()
    properties["mail.smtp.host"] = "smtp.gmail.com"
    properties["mail.smtp.auth"] = "true"
    properties["mail.smtp.starttls.enable"] = "true"
    properties["mail.smtp.port"] = "587"

    val sesssion = Session.getInstance(properties, object: Authenticator() {
        override fun getPasswordAuthentication(): PasswordAuthentication {
            return PasswordAuthentication(sender, password)
        }
    })

    return try {
        val msg = MimeMessage(sesssion)
        msg.setFrom(InternetAddress(sender))
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver))
        msg.subject = subject
        msg.sentDate = Date(System.currentTimeMillis())
        msg.setText(content)
        Transport.send(msg)
        true
    } catch (e: Exception) {
        println(e.message)
        false
    }
}

fun isValidEmail(email: String): Boolean {
    return try {
        InternetAddress(email).validate()
        true
    } catch (e: Exception) {
        false
    }
}