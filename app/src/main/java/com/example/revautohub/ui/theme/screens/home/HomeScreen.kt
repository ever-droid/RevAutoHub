package com.example.revautohub.ui.theme.screens.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.revautohub.R
import com.example.revautohub.navigation.ROUT_DETAILS
import com.example.revautohub.ui.theme.black
import com.example.revautohub.ui.theme.orange
import com.example.revautohub.navigation.ROUT_SPLASH
import com.example.revautohub.ui.theme.lightblue
import com.example.revautohub.ui.theme.white
import com.example.revautohub.ui.theme.yellow


@Composable
fun HomeScreen(navController:NavController){

    Column (
        modifier = Modifier
            .fillMaxSize() .background(color = Color.Yellow),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {

        Spacer(modifier = Modifier.height(20.dp))


        Image(painter = painterResource(id = R.drawable.cartraced),
            contentDescription = "",
            modifier = Modifier.size(180.dp)


        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Bringing It Closer To You",
            fontSize = 23.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.ExtraBold,
            color = black


        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { navController.navigate(ROUT_DETAILS) },
            colors = ButtonDefaults.buttonColors(black),


        )

        {

            Text(
                text = "Let's Go!!!",
                color = white,
                fontSize = 20.sp

            )

        }






    }


}




@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){

    HomeScreen(navController = rememberNavController())

}