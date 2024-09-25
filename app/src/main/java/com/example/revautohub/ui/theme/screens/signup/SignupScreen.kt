package com.example.revautohub.ui.theme.screens.signup
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.revautohub.R
import com.example.revautohub.data.AuthViewModel
import com.example.revautohub.navigation.ROUT_LOGIN
import com.example.revautohub.ui.theme.black
import com.example.revautohub.ui.theme.orange
import com.example.revautohub.ui.theme.white
import com.example.revautohub.ui.theme.yellow


@Composable
fun SignupScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()  .paint(
                painterResource(id = R.drawable.yellowbg),
                contentScale = ContentScale.FillBounds
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = painterResource(id = R.drawable.cartraced),
            contentDescription = "Product",
            modifier = Modifier.size(80.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "RevAutoHub",
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.ExtraBold

            )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Do not have an account? Create Account",
            fontSize = 23.sp,
            textAlign = TextAlign.Center

        )

        var name by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var confpassword by remember { mutableStateOf("") }

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = name ,
            onValueChange = {name = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "", tint = black)},
            label = { Text(text = "Fullname", color = black)},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = email ,
            onValueChange = {email = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "", tint = black)},
            label = { Text(text = "Email Address", color = black )},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(10.dp))

        var passwordVisible by remember { mutableStateOf(false) }
        // Function to determine visual transformation based on visibility
        val visualTransformation: VisualTransformation =
            if (passwordVisible) VisualTransformation.None
            else PasswordVisualTransformation()
        // Function to switch the password visibility
        fun togglePasswordVisibility() {
            passwordVisible = !passwordVisible
        }

        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = { Text(text = "Password", fontFamily = FontFamily.SansSerif , color = Color.Black)},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "", tint = black) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            shape = RoundedCornerShape(5.dp),
            visualTransformation = visualTransformation,
            trailingIcon= {
                val icon = if (passwordVisible) {
                    //Download a password show icon
                    painterResource(id = R.drawable.passwordvisible ,)
                } else {
                    //Download a password hide icon
                    painterResource(id = R.drawable.hidepassword)
                }
                IconButton(onClick = { togglePasswordVisibility() }) {
                    Icon(painter = icon, contentDescription = null)
                }
            }

        )



        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = confpassword ,
            onValueChange = {confpassword = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "", tint = black)},
            label = { Text(text = "Confirm Password", color = black)},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(10.dp))

        val context = LocalContext.current
        val authViewModel = AuthViewModel(navController, context)

        Button(
            onClick = {
                authViewModel.signup(name, email, password,confpassword)

            },
            colors = ButtonDefaults.buttonColors(Color.Yellow),
            shape = RoundedCornerShape(10.dp)

        ) {
            Text(text = "Create an Account", color = black)

        }

        Spacer(modifier = Modifier.height(10.dp))

        Row {
            Text(
                text = "Already have an account?",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.clickable { navController.navigate(ROUT_LOGIN) },
                textDecoration = TextDecoration.Underline,

            )


        }














    }



}

@Composable
@Preview(showBackground = true)
fun AboutScreenPreview(){
    SignupScreen(rememberNavController())
}
