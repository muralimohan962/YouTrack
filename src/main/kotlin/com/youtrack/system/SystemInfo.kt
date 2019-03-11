package com.youtrack.system

val isMac: Boolean
    get() {
        return System.getProperty("os.name").contains("Mac", ignoreCase = true)
    }

val isWindows: Boolean
    get() {
        return System.getProperty("os.name").contains("Windows", ignoreCase = true)
    }

val isLinux: Boolean
    get() {
        return System.getProperty("os.name").contains("Linux", ignoreCase = true)
    }