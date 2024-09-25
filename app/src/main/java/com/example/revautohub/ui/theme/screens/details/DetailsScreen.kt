package com.example.revautohub.ui.theme.screens.details

import android.annotation.SuppressLint
import android.content.Intent
import android.provider.MediaStore
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
import com.example.revautohub.navigation.ADD_TASK
import com.example.revautohub.navigation.ROUT_BOOKING
import com.example.revautohub.navigation.ROUT_DETAILS
import com.example.revautohub.navigation.VIEW_Customer
import com.example.revautohub.ui.theme.black
import com.example.revautohub.ui.theme.darkblue
import com.example.revautohub.ui.theme.lightblue
import com.example.revautohub.ui.theme.yellow


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController){

    Column(
        modifier = Modifier
            .fillMaxSize()
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val mContext = LocalContext.current

        var selected by remember { mutableIntStateOf(0) }
        Scaffold(
            bottomBar = {
                NavigationBar (
                    containerColor = Color.Yellow,
                    contentColor = Color.White){
                    bottomNavItems.forEachIndexed { index, bottomNavItem ->
                        NavigationBarItem(
                            selected = index == selected,
                            onClick = {
                                selected = index
                                navController.navigate(bottomNavItem.route)
                            },
                            icon = {
                                BadgedBox(
                                    badge = {
                                        if (bottomNavItem.badges != 0) {
                                            Badge (containerColor = Color.White){
                                                Text(text = bottomNavItem.badges.toString())
                                            }
                                        } else if (bottomNavItem.hasNews) {
                                            Badge()
                                        }
                                    }
                                ) {
                                    Icon(imageVector =
                                    if (index == selected)
                                        bottomNavItem.selectedIcon
                                    else
                                        bottomNavItem.unselectedIcon,
                                        contentDescription = bottomNavItem.title)
                                }

                            },
                            label = {
                                Text(text = bottomNavItem.title)
                            }
                        )
                    }
                }
            },

            topBar = {

                TopAppBar(
                    title = { Text(text = "RevAutoHub", fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.ExtraBold, color = black) },
                    colors = TopAppBarDefaults.mediumTopAppBarColors(yellow),
                    navigationIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "", tint = black)

                        }
                    },
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.Notifications, contentDescription = "", tint = Color.Black)

                        }

                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "", tint = Color.Black )

                        }

                    }


                )





            },





            floatingActionButton = {
                FloatingActionButton(
                    onClick = {  navController.navigate(ADD_TASK) },
                    containerColor = Color.Yellow) {
                    IconButton(onClick = {
                        navController.navigate(ADD_TASK)

                    }) {
                        Icon(imageVector = Icons.Default.Add, tint = black,
                            contentDescription = "menu")
                    }
                }
            },
            //Content Section
            content = @Composable{
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){

                    Spacer(modifier = Modifier.height(70.dp), )



                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "Find Your Fix!!",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center

                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = "Out of Oil? We Bring the Fuel to You!",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    //Row
                    Row(Modifier.horizontalScroll(rememberScrollState())) {
                        Card(modifier = Modifier
                            .height(130.dp)
                            .width(100.dp)
                            .padding(start = 20.dp)) {

                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                                Image(painter = painterResource(id = R.drawable.oil3),
                                    contentDescription = "",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )

                            }

                        }

                        Spacer(modifier = Modifier.width(7.dp))

                        Card(modifier = Modifier
                            .height(130.dp)
                            .width(100.dp)) {

                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                                Image(painter = painterResource(id = R.drawable.oil4),
                                    contentDescription = "",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )

                            }

                        }

                        Spacer(modifier = Modifier.width(7.dp))

                        Card(modifier = Modifier
                            .height(130.dp)
                            .width(100.dp))
                        {

                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                                Image(painter = painterResource(id = R.drawable.castrooil),
                                    contentDescription = "",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )

                            }

                        }

                        Spacer(modifier = Modifier.width(7.dp))

                        Card(modifier = Modifier
                            .height(130.dp)
                            .width(100.dp))
                        {

                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                                Image(painter = painterResource(id = R.drawable.oil5),
                                    contentDescription = "",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )

                            }

                        }



                    }//End of Row

                    Spacer(modifier = Modifier.height(50.dp))

                    //CALLS
                    Button(onClick = { navController.navigate(VIEW_Customer) },
                        colors = ButtonDefaults.buttonColors(
                            yellow
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 15.dp, end = 15.dp)

                    ) {
                        Text(text = "View",
                            color = black,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 18.sp

                        )

                    }

                    Spacer(modifier = Modifier.height(50.dp))
                    Text(
                        text = "Stuck? We’ll Get You Moving!",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    Row(Modifier.horizontalScroll(rememberScrollState())) {
                        Card(modifier = Modifier
                            .height(130.dp)
                            .width(100.dp)) {

                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                                Image(painter = painterResource(id = R.drawable.mechanic1),
                                    contentDescription = "",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )

                            }

                        }

                        Spacer(modifier = Modifier.width(7.dp))

                        Card(modifier = Modifier
                            .height(130.dp)
                            .width(100.dp)) {

                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                                Image(painter = painterResource(id = R.drawable.mechanic2),
                                    contentDescription = "",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )

                            }

                        }

                        Spacer(modifier = Modifier.width(7.dp))

                        Card(modifier = Modifier
                            .height(130.dp)
                            .width(100.dp))
                        {

                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                                Image(painter = painterResource(id = R.drawable.mechanic3),
                                    contentDescription = "",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )

                            }

                        }

                        Spacer(modifier = Modifier.width(7.dp))

                        Card(modifier = Modifier
                            .height(130.dp)
                            .width(100.dp))
                        {

                            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                                Image(painter = painterResource(id = R.drawable.mechanic4),
                                    contentDescription = "",
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )

                            }

                        }



                    }//End of Row















                }

            }

        )

    }



}




val bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        route="home",
        selectedIcon=Icons.Filled.Home,
        unselectedIcon=Icons.Outlined.Home,
        hasNews = false,
        badges=0
    ),



    BottomNavItem(
        title = "Contact",
        route="booking",
        selectedIcon=Icons.Filled.Add,
        unselectedIcon=Icons.Outlined.Add,
        hasNews = true,
        badges=0
    ),

    BottomNavItem(
        title = "View",
        route="view",
        selectedIcon=Icons.Filled.Info,
        unselectedIcon=Icons.Outlined.Info,
        hasNews = true,
        badges=1
    ),
    BottomNavItem(
        title = "Upload",
        route="view",
        selectedIcon=Icons.Filled.Info,
        unselectedIcon=Icons.Outlined.Info,
        hasNews = true,
        badges=1
    ),


    )



data class BottomNavItem(
    val title :String,
    val route :String,
    val selectedIcon: ImageVector,
    val unselectedIcon : ImageVector,
    val hasNews :Boolean,
    val badges :Int
)



@Composable
@Preview(showBackground = true)
fun DetailsScreenPreview(){
    DetailsScreen(rememberNavController())
}
