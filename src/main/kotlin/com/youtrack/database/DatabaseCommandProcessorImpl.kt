package com.youtrack.database

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

class DatabaseCommandProcessorImpl(private val credentials: DatabaseCredentials) : DatabaseCommandProcessor {
    private lateinit var myConnection: Connection
    private lateinit var myStatement: Statement

    override fun connect(): Boolean {
        return try {
            Class.forName(DRIVER_CLASS)
            myConnection = DriverManager.getConnection(credentials.url, credentials.userName, credentials.pasxword)
            myStatement = myConnection.createStatement()
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    override fun isConnected(): Boolean = myConnection.isValid(2)

    override fun execute(sql: String) {
        if (!::myStatement.isInitialized) return
        myStatement.execute(sql)
    }

    override fun executeQuery(sql: String): ResultSet? {
        if (!::myStatement.isInitialized) return null
        return try {
            myStatement.executeQuery(sql)
        } catch (e: Exception) {
            null
        }
    }


    companion object {
        private var INSTANCE: DatabaseCommandProcessorImpl? = null

        fun create(credentials: DatabaseCredentials): DatabaseCommandProcessorImpl  {
            if (INSTANCE == null) {
                INSTANCE = DatabaseCommandProcessorImpl(credentials).apply { connect() }
            }
            return INSTANCE!!
        }
    }
}