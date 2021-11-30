package com.example.sundmadinepal.facilitator.permission

import android.app.Application
import android.content.Intent
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import kotlinx.coroutines.channels.Channel

class PermissionFacilitator(private val application: Application) {
    private val _permissionReports = Channel<Map<String, Boolean>>(Channel.BUFFERED)

    fun isPermissionRequired(permission: String): Boolean {
        return ContextCompat
            .checkSelfPermission(application, permission) != PackageManager.PERMISSION_GRANTED
    }

    suspend fun requestPermissions(vararg permissions: String): Map<String, Boolean> {
        application.startActivity(
            PermissionActivity.with(application, permissions)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        )

        return _permissionReports.receive()
    }

    fun reportPermissionsStatus(report: Map<String, Boolean>) {
        _permissionReports.trySend(report)
    }
}