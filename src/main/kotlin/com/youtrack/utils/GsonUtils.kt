package com.youtrack.utils

import com.google.gson.GsonBuilder
import com.youtrack.issue.IssuePriority
import com.youtrack.issue.IssueState
import com.youtrack.issue.impl.IssueImpl
import com.youtrack.persistence.StorageManager
import com.youtrack.persistence.StorageManagerImpl
import com.youtrack.user.User
import com.youtrack.user.UserCredentials
import java.io.*
import kotlin.concurrent.thread

private fun toJson(src: Any) = GsonBuilder().create().toJson(src)

private fun fromJson(json: String, clazz: Class<*>) = GsonBuilder().create().fromJson(json, clazz)

object StorageUtils {
    val storageManager: StorageManager by lazy { getInstance() }

    private fun getInstance(): StorageManager {
        registerShutdownSave()
        val file = File("/home/jetbrains/storage/storage.obj")
        return try {
            if (file.exists()) {
                val dataHolder = ObjectInputStream(FileInputStream(file)).readObject() as JsonDataHolder
                if (dataHolder.json != null)
                    fromJson(dataHolder.json, StorageManagerImpl::class.java) as StorageManagerImpl
                else
                    StorageManagerImpl()
            } else
                StorageManagerImpl()
        } catch (e: Exception) {
            StorageManagerImpl()
        }
    }

     private fun registerShutdownSave() {
         Runtime.getRuntime().addShutdownHook(thread(start = false, isDaemon = false) {
             val file = File("/home/jetbrains/storage/storage.obj")
             if (file.exists())
                 file.delete()
             file.createNewFile()
             ObjectOutputStream(FileOutputStream(file)).writeObject(JsonDataHolder(toJson(storageManager)))
         })
    }
}

private data class JsonDataHolder(val json: String? = null) : Serializable

val user = User("Murali", UserCredentials("muralimohan962@gmail.com", "price24"))

val issue = IssueImpl(
    "Intellij IDEa is freezing",
    "I see Intellij IDEA freezing all the time",
    IssuePriority.HIGH,
    IssueState.NOT_YET_RESOLVED,
    "Cosmetics",
    "Intellij IDEA",
    user,
    user,
    "2019.2"
)
