package com.taskmo.util

import android.app.Activity
import android.content.Context
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale
import androidx.core.content.PermissionChecker.checkSelfPermission
import com.google.android.material.snackbar.Snackbar

fun checkSelfPermissionCompat(permission: String, context: Context) =
    checkSelfPermission(context, permission)

fun shouldShowRequestPermissionRationaleCompat(permission: String, context: Activity) =
    shouldShowRequestPermissionRationale(context, permission)

fun requestPermissionsCompat(
    permissionsArray: Array<String>,
    requestCode: Int,
    context: Activity
) {
    requestPermissions(context, permissionsArray, requestCode)
}


fun View.showSnackbar(msgId: Int, length: Int) {
    showSnackbar(context.getString(msgId), length)
}

fun View.showSnackbar(msg: String, length: Int) {
    showSnackbar(msg, length, null, {})
}

fun View.showSnackbar(
    msgId: Int,
    length: Int,
    actionMessageId: Int,
    action: (View) -> Unit
) {
    showSnackbar(context.getString(msgId), length, context.getString(actionMessageId), action)
}

fun View.showSnackbar(
    msg: String,
    length: Int,
    actionMessage: CharSequence?,
    action: (View) -> Unit
) {
    val snackbar = Snackbar.make(this, msg, length)
    if (actionMessage != null) {
        snackbar.setAction(actionMessage) {
            action(this)
        }.show()
    }
}