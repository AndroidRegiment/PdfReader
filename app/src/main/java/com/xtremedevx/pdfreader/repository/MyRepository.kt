package com.xtremedevx.pdfreader.repository

import android.content.Context
import com.xtremedevx.pdfreader.model.Pdf

interface MyRepository {
     fun getAllDocumentFromStorage(context: Context): List<Pdf>

//    suspend fun getAllFavoriteDocument() : List<String>
//
//    suspend fun addDocumentToFavorite() : Boolean
//
//    suspend fun removeDocumentFromFavorite() : Boolean
//
//    suspend fun isDocumentFavorite() : Boolean
}