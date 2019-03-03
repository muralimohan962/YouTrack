package com.youtrack.ws

import javax.jws.WebService

@WebService(endpointInterface = "com.youtrack.ws.HelloWorldServer")
class HelloWorldServerImpl : HelloWorldServer {

    override fun sayHello(name: String): String = "Hello $name! Hope you are well."
}