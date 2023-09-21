package com.example.firstcompose.layout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.fragment.app.Fragment
import com.example.firstcompose.R

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

}