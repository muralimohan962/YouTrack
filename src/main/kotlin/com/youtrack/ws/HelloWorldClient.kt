package com.youtrack.ws

import java.net.URL
import javax.xml.namespace.QName
import javax.xml.ws.Service

fun main() {
    try {
        val url = URL("http://localhost:9876/hw?wsdl")
        val qname = QName("http://ws.youtrack.com/", "HelloWorldServerImplService")

        val service = Service.create(url, qname)

        val server = service.getPort(HelloWorldServer::class.java)
        val name = "Murali"
        println(server.sayHello(name))
    } catch (e: Exception) {
        println(e.message)
    }
}