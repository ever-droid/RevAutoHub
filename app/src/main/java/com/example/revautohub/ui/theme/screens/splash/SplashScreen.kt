package com.example.revautohub.ui.theme.screens.splash

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.revautohub.R
import com.example.revautohub.navigation.ROUT_LOGIN
import com.example.revautohub.ui.theme.lightorange
import com.example.revautohub.ui.theme.orange
import kotlinx.coroutines.launch


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navController: NavController){
    Column(modifier = Modifier.fillMaxSize()) {
        Card (modifier = Modifier
            .fillMaxWidth()
            .height(280.dp),
            shape = RoundedCornerShape(bottomStart = 50.dp , bottomEnd = 50.dp),
            colors = CardDefaults.cardColors(lightorange)
        ){
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                val coroutine = rememberCoroutineScope()
                coroutine.launch {
                    kotlinx.coroutines.delay(3000)
                    navController.navigate(ROUT_LOGIN)
                }
                Image(
                    painter = painterResource(id = R.drawable.shop),
                    contentDescription = "Product",
                    modifier = Modifier.size(100.dp)
                )

                Text(
                    text = "Welcome to SellApy",
                    fontSize = 50.sp,
                    color = Color.Black,
                    fontFamily = FontFamily.Cursive,
                    fontWeight = FontWeight.ExtraBold

                )

                Text(
                    text = "The home of fashion",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.ExtraBold

                )

            }




        }
        Spacer(modifier = Modifier.height(20.dp), )
        Text(
            text = "As SellApy, we act in line with our vision of becoming one of the three most successful clothing brands in Europe. With our mission of \"Everyone Deserves to Dress Well\", we continue to grow with our own stores at domestic and abroad, and" +
                    " with our franchise partners in countries where there are legal obligations.",
            fontSize = 18.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,


        )
        Spacer(modifier = Modifier.height(20.dp), )
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(orange),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp)

        ) {
            Text(text = "LET'S BEGIN")

        }




    }



}

@Composable
@Preview(showBackground = true)
fun SplashScreenPreview(){
    SplashScreen(rememberNavController())
}
