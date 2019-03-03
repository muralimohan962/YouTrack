package com.youtrack.concurrency

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

object AppExecutorUtil {
    private val myExecutorService: ExecutorService =
        Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() - 1)
    private val myScheduledExecutorService: ScheduledExecutorService =
        Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors() - 1)

    init {
        Runtime.getRuntime().addShutdownHook(thread(start = false) {
            println("Shutting down thread pools!")
            myExecutorService.shutdownNow()
            myScheduledExecutorService.shutdownNow()
        })
    }

    fun getExecutorService(): ExecutorService = myExecutorService

    fun getScheduledExecutorService(): ScheduledExecutorService = myScheduledExecutorService

    fun shutdown() {
        getExecutorService().awaitTermination(3, TimeUnit.SECONDS)
        getScheduledExecutorService().awaitTermination(3, TimeUnit.SECONDS)
    }
}