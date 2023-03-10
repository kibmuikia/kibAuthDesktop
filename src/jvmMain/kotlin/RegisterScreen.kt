import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

class RegisterScreen {

    private data class registerData(
        var firstName: String = "",
        var lastName: String = "",
        var phoneNumber: String = "",
        var email: String = "",
        var password: String = "",
    )

    @Composable
    fun registerScreen() {
        registerScreenContent()
    }

    @Composable
    private fun registerScreenContent() {
        val scaffoldState = rememberScaffoldState()
        val registerDataState by remember { mutableStateOf(registerData()) }
        val scope = rememberCoroutineScope()

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            scaffoldState = scaffoldState
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize().padding(horizontal = 24.dp)
            ){

                TextField(
                    value = registerDataState.firstName,
                    label = {
                        Text("Enter your First Name")
                    },
                    onValueChange = {
                        registerDataState.firstName = it
                    },
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                        autoCorrect = false,
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = registerDataState.lastName,
                    label = {
                        Text("Enter your Last Name")
                    },
                    onValueChange = {
                        registerDataState.lastName = it
                    },
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                        autoCorrect = false,
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    singleLine = true, modifier = Modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = registerDataState.email,
                    label = {
                        Text("Enter your Email")
                    },
                    onValueChange = {
                        registerDataState.email = it
                    },
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                        autoCorrect = false,
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    singleLine = true, modifier = Modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = registerDataState.phoneNumber,
                    label = {
                        Text("Enter your Phone Number")
                    },
                    onValueChange = {
                        registerDataState.phoneNumber = it
                    },
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                        autoCorrect = false,
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    singleLine = true, modifier = Modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = registerDataState.password,
                    label = {
                        Text("Enter your Password")
                    },
                    onValueChange = {
                        registerDataState.password = it
                    },
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                        autoCorrect = false,
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Next
                    ),
                    visualTransformation = PasswordVisualTransformation(),
                    singleLine = true, modifier = Modifier.fillMaxWidth(),
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("Your Data: $registerDataState")
                    }
                }){
                    Text("Register")
                }

            }
        }
    }

}