package com.youtrack.ws

import javax.xml.ws.Endpoint

fun main() {
    println("Publishing......")
    Endpoint.publish("http://127.0.0.1:9876/hw", HelloWorldServerImpl())
    println("Successfully published!")
}