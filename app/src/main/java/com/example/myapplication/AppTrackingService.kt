package com.example.myapplication

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent

class AppTrackingService : AccessibilityService() {

    override fun onServiceConnected() {
        super.onServiceConnected()
        // Do any initialization here
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent) {
        if (event.eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
            // App opened or closed
            val packageName = event.packageName?.toString()
            val className = event.className?.toString()

            if (packageName != null && className != null) {
                if (event.eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
                    // App opened
                    val appName = getAppName(packageName)
                    val eventText = "App opened: $appName"
                    // Log or handle the event as needed
                    // For example, you can use println() or Log.d()
                    println(eventText)
                }
            }
        }
    }

    override fun onInterrupt() {
        // Handle interruption of accessibility service
    }

    private fun getAppName(packageName: String): String {
        // Retrieve the app name based on the package name
        // You can implement your own logic or use a utility method/library
        // to get the app name for the given package name
        // For simplicity, return the package name itself
        return packageName
    }
}
