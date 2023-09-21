package com.example.firstcompose.layout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.example.firstcompose.R
import com.example.firstcompose.ui.theme.ComposeSampleTheme

class LayoutFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent{
            val title = stringResource(id = R.string.lorem_ipsum)
            val description = (0..10).joinToString { title }

            Body(
                url = "https://picsum.photos/300/300",
                title = title,
                description = description,
                price = 300.00,
                comments = (0..5).map{
                    Comment(
                        image = "https://picsum.photos/300/300",
                        name = "Hello",
                        text = stringResource(id = R.string.lorem_ipsum)
                    )
                }
            )
        }
    }
}
@Composable
fun Body(
    url: String?,
    title: String,
    description: String,
    price: Double,
    comments: List<Comment>
){
    ComposeSampleTheme{
        Column (
            Modifier
                .fillMaxHeight()
                .verticalScroll(rememberScrollState())
        ){
            GlideImageWithPreview(
                data = url,
                Modifier
                    .height(120.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.FillBounds
            )
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(all = 20.dp)
            ) {
                Text(
                    text = title,
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                        .padding(end = 6.dp),
                    fontSize = 18.sp,
                )

            }
        }
    }
}