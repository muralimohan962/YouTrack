package com.youtrack.issue

object Subsystem {
    const val NOT_YET_DETERMINED = "Not yet determined"
    private val subsystems = mutableListOf(NOT_YET_DETERMINED)

    fun register(subsystem: String) {
        subsystems.add(subsystem)
    }

    fun unregister(subsystem: String) {
        subsystems.remove(subsystem)
    }

    fun getSubsystems(): List<String> = subsystems

}