package com.xtremedevx.pdfreader.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xtremedevx.pdfreader.R
import com.xtremedevx.pdfreader.data.model.Pdf
import com.xtremedevx.pdfreader.presentation.ui.theme.LightRed

@Composable
fun PdfItem(pdf: Pdf) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        shape = RoundedCornerShape(10.dp),
        color = LightRed,


        ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.pdf),
                modifier = Modifier.height(50.dp),
                contentDescription = null
            )

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    text = pdf.fileTitle, fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    text = "${pdf.size} |  ${pdf.date}",
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
            Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "Favorite")
        }
    }
}

@Preview
@Composable
fun PrevPdf() {
    PdfItem(
        pdf = Pdf(
            fileTitle = "This is My Pdf",
            fileUri = "/inYourBackPocket",
            size = 90_000,
            date = "22/2/22"
        )
    )
}