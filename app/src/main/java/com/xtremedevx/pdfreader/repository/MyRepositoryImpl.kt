package com.xtremedevx.pdfreader.repository

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
import android.webkit.MimeTypeMap
import com.xtremedevx.pdfreader.model.Pdf

class MyRepositoryImpl : MyRepository {

    override fun getAllDocumentFromStorage(context: Context): List<Pdf> {

        val pdfList = mutableListOf<Pdf>()

        val collection = MediaStore.Files.getContentUri("external")

        val projection = arrayOf(
            MediaStore.Files.FileColumns.TITLE,
            MediaStore.Files.FileColumns.SIZE,
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
            val dataCol = cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DATA)


            if (cursor.moveToFirst()) {
                Log.i("TEST", "Cursor move first")
                do {
                    val fileUri: Uri = Uri.withAppendedPath(
                        MediaStore.Files.getContentUri("external"),
                        cursor.getString(dataCol)
                    )
                    val title = cursor.getString(titleCol)
                    val size = cursor.getLong(sizeCol)

                    pdfList.add(
                        Pdf(
                            fileTitle = title,
                            fileUri = fileUri.toString(),
                            size = size
                        )
                    )

                } while (cursor.moveToNext())
            }
            cursor.close()
        }

        return pdfList
    }


}


