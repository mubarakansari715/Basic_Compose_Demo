package com.mubarak.basic_compose_demo.login

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mubarak.basic_compose_demo.R

@Composable
fun LoginPageDesign(
    navController: NavController,
) {

    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisibility: Boolean by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }

    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "Login Page", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(16.dp))

        //Email
        OutlinedTextField(
            value = userName,
            onValueChange = { userName = it },
            placeholder = { Text(text = "Enter Email") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            leadingIcon = { Icon(Icons.Filled.Email, contentDescription = "email") },
            modifier = Modifier
                .padding(horizontal = 18.dp)
                .fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(16.dp))

        //Password
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text(text = "Enter Password") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "password") },
            modifier = Modifier
                .padding(horizontal = 18.dp)
                .fillMaxWidth(),
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (passwordVisibility)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                // Please provide localized description for accessibility services
                val description = if (passwordVisibility) "Hide password" else "Show password"

                IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                    Icon(imageVector = image, description)
                }
            },
            keyboardActions = KeyboardActions(onDone = KeyboardActions.Default.onDone)

        )

        Spacer(modifier = Modifier.height(16.dp))

        //Button Click
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Button(onClick = {
                showDialog = true
                if (userName.isNotEmpty() && password.isNotEmpty()) {
                    Toast.makeText(context, "login success", Toast.LENGTH_SHORT).show()
                } else {
                    //Toast.makeText(context, "empty", Toast.LENGTH_SHORT).show()
                }
            }) {
                Text(text = "Login")
            }

            //Signup Button
            Button(onClick = { navController.navigate("signup") },  enabled = false) {
                Text(text = "Sign Up")
            }

            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { /*TODO*/ },
                    title = { Text(text = "Login successfully") },
                    text = { Text(text = "WoW!!") },
                    confirmButton = {

                        Button(
                            onClick = {
                                navController.navigate("post")
                                showDialog = false
                                //Toast.makeText(context, "Clicked :: Yes", Toast.LENGTH_SHORT).show()
                            },
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                            elevation = null
                        ) {
                           // Text(text = stringResource(id = R.string.key_yes))
                            Text(text = "API Calling Data Show")

                        }

                    },
                    dismissButton = {

                        Button(
                            onClick = {
                                showDialog = false
                                //Toast.makeText(context, "Clicked :: Not", Toast.LENGTH_SHORT).show()
                                navController.navigate("home")
                            },

                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                            elevation = null
                        ) {
                            //Text(text = stringResource(R.string.key_no))
                            Text(text = "Dummy Data Show")

                        }
                    }
                )
            }

        }


    }

}

