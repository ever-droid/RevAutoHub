package com.example.revautohub.ui.theme.screens.login
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.revautohub.R
import com.example.revautohub.data.AuthViewModel
import com.example.revautohub.navigation.ROUT_SIGNUP
import com.example.revautohub.ui.theme.orange


@Composable
fun LoginScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(painterResource(id = R.drawable.bubbles), contentScale = ContentScale.FillBounds),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = painterResource(id = R.drawable.shop),
            contentDescription = "Product",
            modifier = Modifier.size(180.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Welcome back!!",
            fontSize = 50.sp,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.ExtraBold

        )


        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Already have an account? Please enter your credentials",
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Serif

        )

        Spacer(modifier = Modifier.height(10.dp))

        var password by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }



        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = email ,
            onValueChange = {email = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "", tint = orange) },
            label = { Text(text = "Email Address")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(20.dp))

        val context = LocalContext.current
        val authViewModel = AuthViewModel(navController, context)

        Row {


            Button(
                onClick = { authViewModel.login(email, password) },
                colors = ButtonDefaults.buttonColors(orange),
                shape = RoundedCornerShape(10.dp)

            ) {
                Text(text = "Login as User")

            }

            Spacer(modifier = Modifier.width(20.dp))

            Button(
                onClick = {authViewModel.login(email, password)},
                colors = ButtonDefaults.buttonColors(orange),
                shape = RoundedCornerShape(10.dp)

            ) {
                Text(text = "Login as Admin")

            }


        }
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Do not have an account? Register",
            fontSize = 18.sp,
            fontFamily = FontFamily.Serif,
            modifier = Modifier.clickable { navController.navigate(ROUT_SIGNUP) }


        )









    }



}

@Composable
@Preview(showBackground = true)
fun LoginScreenPreview(){
    LoginScreen(rememberNavController())
}
