package com.example.revautohub.ui.theme.screens.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.revautohub.R
import com.example.revautohub.ui.theme.black
import com.example.revautohub.ui.theme.orange
import com.example.sellapy.navigation.ROUT_SPLASH


@Composable
fun HomeScreen(navController:NavController){

    Column (
        modifier = Modifier
            .fillMaxSize()
            .paint(painterResource(id = R.drawable.bubbles), contentScale = ContentScale.FillBounds),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {

        Image(
            painter = painterResource(id = R.drawable.shop),
            contentDescription = "Product",
            modifier = Modifier.size(200.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "SellApy",
            fontSize = 40.sp,
            fontFamily = FontFamily.Cursive,
            color = black,

        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = { navController.navigate(ROUT_SPLASH)},
            colors = ButtonDefaults.buttonColors(orange),
            shape = RoundedCornerShape(10.dp)

        ) {
            Text(text = "Get Started")

        }




    }


}




@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){

    HomeScreen(navController = rememberNavController())

}