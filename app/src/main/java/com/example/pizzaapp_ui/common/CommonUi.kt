package com.example.pizzaapp_ui.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun HeaderIconButt(
                @DrawableRes icon: Int,
                tint : Color = Color.Unspecified,  // it take by default color of icon
                modifier: Modifier=Modifier,
                onClick :() -> Unit={}

) {
    IconButton(onClick = {onClick},modifier=Modifier.size(28.dp)) {
                Icon(painter = painterResource(id =icon), contentDescription = null,tint=tint)
    }
}


@Composable
fun SpacerHeight(height:Dp=5.dp) {
    Spacer(modifier = Modifier.height(height))
    
}

@Composable
fun SpacerWidth(widtht:Dp=5.dp) {
    Spacer(modifier = Modifier.width(widtht))

}