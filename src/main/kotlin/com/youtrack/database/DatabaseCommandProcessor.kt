package com.youtrack.database

import java.sql.ResultSet

interface DatabaseCommandProcessor {
    fun execute(sql: String)
    fun executeQuery(sql: String): ResultSet?
    fun connect(): Boolean
    fun isConnected(): Boolean
}