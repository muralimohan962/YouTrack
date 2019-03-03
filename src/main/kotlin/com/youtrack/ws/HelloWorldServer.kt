package com.youtrack.ws

import javax.jws.WebMethod
import javax.jws.WebService
import javax.jws.soap.SOAPBinding

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
interface HelloWorldServer {

    @WebMethod
    fun sayHello(name: String): String
}