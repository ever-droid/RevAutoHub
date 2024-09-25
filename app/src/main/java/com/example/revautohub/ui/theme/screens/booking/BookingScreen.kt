package com.example.revautohub.ui.theme.screens.booking

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.revautohub.R
import com.example.revautohub.ui.theme.black
import com.example.revautohub.ui.theme.blue
import com.example.revautohub.ui.theme.lightblue
import com.example.revautohub.ui.theme.lightpurple
import com.example.revautohub.ui.theme.white


@Composable
fun BookingScreen(navController: NavController){

    Column (modifier = Modifier
        .fillMaxSize()
        .paint(
            painterResource(id = R.drawable.yellowbg),
            contentScale = ContentScale.FillBounds
        ),)
    {

        Spacer(modifier = Modifier.height(20.dp))
        Image(painter = painterResource(id = R.drawable.cartraced),
            contentDescription = "",
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.CenterHorizontally),




        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Oil Services Brought To You",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
            )
        
        Spacer(modifier = Modifier.height(15.dp))
        

        Row {

            

            Card(
                colors = CardDefaults.cardColors(lightpurple),
                modifier = Modifier
                    .height(200.dp)
                    .width(180.dp)
                    .padding(start = 15.dp, end = 5.dp)

            ) {

                Box (modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

                    Image(painter = painterResource(id = R.drawable.oil3),
                        contentDescription = "",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )

                }


            }
            
            Spacer(modifier = Modifier.width(10.dp))

            Card(
                colors = CardDefaults.cardColors(lightpurple),
                modifier = Modifier
                    .height(200.dp)
                    .width(180.dp)
                    .padding(start = 15.dp, end = 5.dp)

            ) {

                Box (modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                    Image(painter = painterResource(id = R.drawable.oilbooking),
                        contentDescription = "",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )

                }


            }


        }
        
        Spacer(modifier = Modifier.height(8.dp))

        val mContext = LocalContext.current
        Button(
            onClick = {val callIntent= Intent(Intent.ACTION_DIAL)
                callIntent.data="tel:0746234416".toUri()
                mContext.startActivity(callIntent) },
            colors = ButtonDefaults.buttonColors(black),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 18.dp, end = 18.dp)

        ) {
            Text(text = "Call",
                color = white,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )

        }





        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Elite Mechanical Solutions Delivered",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(10.dp))


        Row{



            Card(
                colors = CardDefaults.cardColors(lightpurple),
                modifier = Modifier
                    .height(200.dp)
                    .width(180.dp)
                    .padding(start = 15.dp, end = 5.dp)

            ) {

                Box (modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){

                    Image(painter = painterResource(id = R.drawable.mechanic2),
                        contentDescription = "",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )

                }


            }

            Spacer(modifier = Modifier.width(10.dp))

            Card(
                colors = CardDefaults.cardColors(lightpurple),
                modifier = Modifier
                    .height(200.dp)
                    .width(180.dp)
                    .padding(start = 15.dp, end = 5.dp)

            ) {

                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                    Image(painter = painterResource(id = R.drawable.mechanicbooking),
                        contentDescription = "",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )

                }


            }


        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {val callIntent= Intent(Intent.ACTION_DIAL)
                callIntent.data="tel:0750345346".toUri()
                mContext.startActivity(callIntent) },
            colors = ButtonDefaults.buttonColors(black),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 18.dp, end = 18.dp)

        ) {
            Text(text = "Call",
                color = white,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold

            )

        }



    }



}

@Composable
@Preview(showBackground = true)
fun BookingScreenPreview(){
    BookingScreen(rememberNavController())
}
