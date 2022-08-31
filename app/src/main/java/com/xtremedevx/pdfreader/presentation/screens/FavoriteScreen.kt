package com.xtremedevx.pdfreader.presentation.screens

import android.app.Activity.RESULT_OK
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign

@Composable
fun FavoriteScreen() {
    Text(text = "Favorite Screen", textAlign = TextAlign.Center, modifier = Modifier.fillMaxSize())

}


fun Uri.getOriginalFileName(context: Context): String? {

    val projection = arrayOf(
        MediaStore.Files.FileColumns.TITLE,
    )

    return context.contentResolver.query(this, projection, null, null, null)?.use {cursor ->
        val titleCol = cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns.TITLE)
        cursor.moveToFirst()

        Log.i("TEST", cursor.getString(titleCol))
        return cursor.getString(titleCol)
    }
}

@Composable
fun AppNotice() {
    Box {

        val path by remember { mutableStateOf("") }
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "*/*"; intent.addCategory(Intent.CATEGORY_OPENABLE);
        val context = LocalContext.current
        val launcher =
            rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
                if (activityResult.resultCode == RESULT_OK) {
                    Log.d("appDebug", "oky")
                    var uri = intent.getData()
                    val name: String? = uri?.getOriginalFileName(context)
                    Log.d("seeFile", "$name")
                }
            }
    }
}