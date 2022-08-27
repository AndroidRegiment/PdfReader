package com.xtremedevx.pdfreader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.xtremedevx.pdfreader.repository.MyRepositoryImpl
import com.xtremedevx.pdfreader.ui.theme.PdfReaderTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PdfReaderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val context = LocalContext.current
                    val repo = MyRepositoryImpl()
                    val list = repo.getAllDocumentFromStorage(context)

                    LazyColumn {
                        items(list) { item ->
                            Column(modifier = Modifier.fillMaxWidth()) {
                                Text(text = "File Title = ${item.fileTitle}")
                                Text(text = "File Path = ${item.fileUri}")
                                Text(text = "File Size ${item.size}")
                                Spacer(modifier = Modifier.height(10.dp))
                            }
                        }
                    }

                }
            }
        }
    }
}
