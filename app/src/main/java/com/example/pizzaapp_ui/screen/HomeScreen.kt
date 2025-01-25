package com.example.pizzaapp_ui.screen

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzaapp_ui.R
import com.example.pizzaapp_ui.common.HeaderIconButt
import com.example.pizzaapp_ui.common.SpacerHeight
import com.example.pizzaapp_ui.common.SpacerWidth
import com.example.pizzaapp_ui.data.Pizza
import com.example.pizzaapp_ui.data.pizzaList
import com.example.pizzaapp_ui.ui.theme.BackgroundColor
import com.example.pizzaapp_ui.ui.theme.DarkBlackColor
import com.example.pizzaapp_ui.ui.theme.LightGrayColor
import com.example.pizzaapp_ui.ui.theme.RedColor
import com.example.pizzaapp_ui.ui.theme.YellowColor

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    val menuList =
        listOf("starter", "Asian", "Vermiform", "Classic", "Standard", "Hero", "Honda", "Splender")
    var currentMenuState by remember { mutableStateOf("starter") }
    var scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ) {
        Column {
            SpacerHeight()
            AppHeader()
            Card(modifier = Modifier.fillMaxWidth()) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(scrollState)) {
                    menuList.forEach {
                        CustomChip(title = it, selected = it == currentMenuState, onValueChange = {
                            currentMenuState = it
                        })
                    }

                }
            }
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(pizzaList){
                    ShowPizza(it)
                }
            }
        }

        ActionButton(modifier=Modifier.padding(horizontal = 20.dp, vertical = 30.dp)
            .align(Alignment.BottomEnd))

    }

}
//compose.material.icons.filled.Menu

@Composable
fun AppHeader(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(RedColor)
    ) {

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 25.dp, horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row() {
                HeaderIconButt(icon = com.example.pizzaapp_ui.R.drawable.menu)
                SpacerWidth()
                Text(
                    text = "Pizza Garage", style = TextStyle(
                        fontSize = 19.sp,
                        fontWeight = FontWeight.W600,
                        color = Color.White
                    )
                )
            }
            HeaderIconButt(icon = com.example.pizzaapp_ui.R.drawable.search)
        }
    }


}

@Composable
fun CustomChip(title: String, selected: Boolean, onValueChange: (String) -> Unit) {
    TextButton(
        onClick = { onValueChange(title) },
        shape = RoundedCornerShape(200.dp),
        colors = ButtonDefaults.textButtonColors(
            containerColor = if (selected) YellowColor else Color.Transparent,

            ),
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 15.dp)
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.W600,
                color = if (selected) Color.White else Color.Black
            )
        )
    }
}

@Composable
fun ShowPizza(
        pizza: Pizza
) {
    Card(
        modifier = Modifier
            .width(175.dp)
            .padding(5.dp), shape = RoundedCornerShape(5.dp)
    ) {
       Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center,) {
           Column(modifier = Modifier
               .padding(5.dp)
               .fillMaxWidth(),
               horizontalAlignment = Alignment.CenterHorizontally) {
               Image(painter = painterResource(id = R.drawable.pizza), contentDescription = "", modifier = Modifier.size(109.dp))
               SpacerHeight()
               Text(
                   text = pizza.price,
                   style = TextStyle(
                       fontSize = 14.sp,
                       fontWeight = FontWeight.W300,
                       color = RedColor,
                       textAlign = TextAlign.Center // Correct placement of TextAlign
                   )
               )
               SpacerHeight()
               Text(
                   text = pizza.name,
                   style = TextStyle(
                       fontSize = 14.sp,
                       fontWeight = FontWeight.W600,
                       color = DarkBlackColor,
                       textAlign = TextAlign.Center // Correct placement of TextAlign
                   )
               )
               SpacerHeight()
               Text(
                   text = pizza.description,
                   style = TextStyle(
                       fontSize = 10.sp,
                       fontWeight = FontWeight.W300,
                       color = LightGrayColor,
                       textAlign = TextAlign.Center // Correct placement of TextAlign
                   )
               )

               SpacerHeight()
               Button(
                   onClick = {},
                   modifier = Modifier.width(91.dp),
                   shape = RoundedCornerShape(18.dp),
                   colors = ButtonDefaults.buttonColors(
                       containerColor = YellowColor
                   )
               ) {
                   Text(text = " Add ", color = Color.White,
                       style =
                       TextStyle(fontSize = 12.sp,
                           fontWeight = FontWeight.W600
                       ))
               }

           }
       }
    }
}


@Composable
fun ActionButton(modifier: Modifier) {  // this modifier call in box
    Box(modifier=modifier.height(48.dp).clip(RoundedCornerShape(27.dp)).
    background(DarkBlackColor)){
        Row{
            SpacerWidth()
            Text(
                text ="$12.78",
                style = TextStyle(
                    fontSize = 17.sp,
                    fontWeight = FontWeight.W600,
                    color = Color.White,
                    //textAlign = TextAlign.Center // Correct placement of TextAlign
                ),modifier=Modifier.align(CenterVertically)
            )
            Icon(painter = painterResource(id =R.drawable.pizza), contentDescription = "",
                modifier=Modifier.size(46.dp).padding(
                    2.dp
                ),
                tint = Color.Unspecified
                )
        }

    }

}