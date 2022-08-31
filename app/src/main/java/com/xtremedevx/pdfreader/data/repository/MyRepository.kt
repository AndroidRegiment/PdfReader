package com.xtremedevx.pdfreader.data.repository

import android.content.Context
import com.xtremedevx.pdfreader.data.model.Pdf

interface MyRepository {
     suspend fun getAllDocumentFromStorage()

//    suspend fun getAllFavoriteDocument() : List<String>
//
//    suspend fun addDocumentToFavorite() : Boolean
//
//    suspend fun removeDocumentFromFavorite() : Boolean
//
//    suspend fun isDocumentFavorite() : Boolean
}