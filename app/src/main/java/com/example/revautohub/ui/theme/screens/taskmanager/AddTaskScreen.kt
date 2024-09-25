package com.example.revautohub.ui.theme.screens.taskmanager

import android.app.DatePickerDialog
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.revautohub.R
import com.example.revautohub.data.TaskViewModel
import com.example.revautohub.navigation.ROUT_ABOUT
import com.example.revautohub.navigation.ROUT_BOOKING
import com.example.revautohub.navigation.ROUT_HOME
import com.example.revautohub.navigation.VIEW_Customer
import com.example.revautohub.navigation.VIEW_TASKS
import com.example.revautohub.ui.theme.black
import com.example.revautohub.ui.theme.white
import java.util.Calendar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskScreen(navController: NavHostController) {
    val context = LocalContext.current


    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.yellowbg), contentScale = ContentScale.FillBounds)
            .verticalScroll(rememberScrollState())
    ) {
        Column (
            modifier = Modifier.padding(horizontal = 12.dp)
        ){

            var taskName by remember { mutableStateOf("") }
            var taskDescription by remember { mutableStateOf("") }

            Spacer(modifier = Modifier.height(30.dp))

            // home icon
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 6.dp),
                verticalAlignment = Alignment.CenterVertically,
            ){
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null,
                    modifier = Modifier.clickable { navController.navigate(ROUT_HOME) },
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "Home",
                    modifier = Modifier.clickable { navController.navigate(ROUT_HOME) },
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
                Row (
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null,
                        modifier = Modifier.clickable {
                            navController.navigate(ROUT_ABOUT)
                        },
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Help",
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.clickable {
                            navController.navigate(ROUT_ABOUT)
                        }
                    )
                }
            }
            //end of home icon
            //intro row
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                Image(
                    painter = painterResource(id = R.drawable.cartraced),
                    contentDescription = "top icon",
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(6.dp)
                )

            }
            Text(
                text = "Book",
                fontSize = 26.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black
            )
            // intro row end
            Spacer(modifier = Modifier.height(5.dp))

            Row (
                modifier= Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                Button(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(topStart = 10.dp, bottomStart = 10.dp),
                    colors = ButtonDefaults.buttonColors(Color.Black)
                ) {
                    Text(
                        text = "Book",
                        fontSize = 16.sp
                    )
                }
                Button(
                    onClick = { navController.navigate(VIEW_TASKS) },
                    shape = RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp),
                    colors = ButtonDefaults.buttonColors(Color.Black),
                ) {
                    Text(
                        text = "View Bookings",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(28.dp))


            OutlinedTextField(
                value = taskName,
                onValueChange = { taskName = it },
                placeholder = { Text(text="eg. Water the plants") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "email icon",
                        tint = Color.Black
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                label = { Text(text = "Booking", color = black) }
            )

            Spacer(modifier = Modifier.height(13.dp))















            OutlinedTextField(
                value = taskDescription,
                onValueChange = { taskDescription = it },
                placeholder = { Text(text="eg. Water the plants using the red hose... ") },
                modifier = Modifier
                    .height(130.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                label = { Text(
                    text = "Booking Description",
                    fontSize = 17.sp,
                    textDecoration = TextDecoration.Underline,
                    color = black
                )
                },
            )

            Spacer(modifier = Modifier.height(15.dp))

            val modifier = Modifier
            val context = LocalContext.current
            TaskUploadButton(modifier,context, navController , taskName.trim() , taskDescription.trim() )

        }
    }
}

@Composable
fun TaskUploadButton(modifier: Modifier = Modifier, context: Context, navController: NavHostController, name:String, description:String){
    Button(onClick = {
        navController.navigate(ROUT_BOOKING)
    },
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(Color.Black),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp, vertical = 20.dp)
    ) {
        Text(
            text = "Book",
            fontSize = 17.sp,
            color = white
        )
    }

}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun AddTaskScreenPreview(){
    AddTaskScreen(navController = rememberNavController())
}