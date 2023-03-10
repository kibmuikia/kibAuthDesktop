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

class LoginScreen {

    private data class LoginData(
        var email: String = "",
        var password: String = "",
    )

    @Composable
    fun loginScreen() {
        loginScreenContent()
    }

    @Composable
    private fun loginScreenContent() {
        val scaffoldState = rememberScaffoldState()
        val loginDataState by remember { mutableStateOf(LoginData()) }
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
                    value = loginDataState.email,
                    label = {
                        Text("Enter your Email")
                    },
                    onValueChange = {
                        loginDataState.email = it
                    },
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                        autoCorrect = false,
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next
                    ),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = loginDataState.password,
                    label = {
                        Text("Enter your Password")
                    },
                    onValueChange = {
                        loginDataState.password = it
                    },
                    // Enable user input from the keyboard
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                        autoCorrect = false,
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Next
                    ),
                    // Enable password input type by showing dots for password security
                    visualTransformation = PasswordVisualTransformation(),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("Your data: $loginDataState")
                    }
                }){
                    Text("Login")
                }
            }
        }
    }

}