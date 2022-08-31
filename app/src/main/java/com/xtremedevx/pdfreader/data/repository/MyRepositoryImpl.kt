package com.xtremedevx.pdfreader.data.repository

import android.app.Application
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import android.webkit.MimeTypeMap
import com.xtremedevx.pdfreader.data.model.Pdf

class MyRepositoryImpl(private val context: Application) : MyRepository {

    override suspend fun getAllDocumentFromStorage(){

        val pdfList = mutableListOf<Pdf>()

        val collection = MediaStore.Files.getContentUri("external")

        val projection = arrayOf(
            MediaStore.Files.FileColumns.TITLE,
            MediaStore.Files.FileColumns.SIZE,
            MediaStore.Files.FileColumns.DATE_MODIFIED,
            MediaStore.Files.FileColumns.DATA,
        )

        val selectionMimeType = "${MediaStore.Files.FileColumns.MIME_TYPE}=?"
        val mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension("pdf")
        val selectionArgs = arrayOf(mimeType)
//        val orderBy = MediaStore.Files.FileColumns.DATE_MODIFIED + " DESC"

        val cursor: Cursor? = context.contentResolver.query(
            collection,
            projection,
            selectionMimeType,
            selectionArgs,
            null
        )
        if (cursor != null) {
            val titleCol = cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns.TITLE)
            val sizeCol = cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns.SIZE)
            val uriCol = cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DATA)
            val dateCol = cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DATE_MODIFIED)
            if (cursor.moveToFirst()) {
                do {
                    val fileUri: Uri = Uri.withAppendedPath(
                        MediaStore.Files.getContentUri("external"),
                        cursor.getString(uriCol)
                    )
                    val title = cursor.getString(titleCol)
                    val size = cursor.getLong(sizeCol)
                    val date = cursor.getString(dateCol)

                    pdfList.add(
                        Pdf(
                            fileTitle = title,
                            fileUri = fileUri.toString(),
                            size = size,
                            date = date
                        )
                    )
                } while (cursor.moveToNext())
            }
            cursor.close()
        }
    }
}