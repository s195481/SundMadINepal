package com.example.sundmadinepal.facilitator.permission

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.sundmadinepal.di.ServiceLocator

class PermissionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val permissionFacilitator = ServiceLocator.permissionFacilitator
        val permissions = intent.permissions
        if (permissions.size > 1) {
            registerForActivityResult(
                ActivityResultContracts.RequestMultiplePermissions()
            ) {
                permissionFacilitator.reportPermissionsStatus(it)
                finish()
            }.launch(permissions)
        } else {
            val singlePermission = permissions.single()
            registerForActivityResult(
                ActivityResultContracts.RequestPermission()
            ) {
                permissionFacilitator.reportPermissionsStatus(mapOf(singlePermission to it))
                finish()
            }.launch(singlePermission)
        }
    }

    companion object {
        private const val EXTRA__PERMISSIONS = "EXTRA__PERMISSIONS"

        fun with(context: Context, permissions: Array<out String>): Intent {
            return Intent(context, PermissionActivity::class.java)
                .putExtra(EXTRA__PERMISSIONS, permissions)
        }

        private val Intent.permissions: Array<out String>
            get() = getStringArrayExtra(EXTRA__PERMISSIONS)!!
    }
}