package com.example.finalapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalapp.LoginRequest
import com.example.finalapp.RetrofitInstance
import kotlinx.coroutines.launch


// This is the LoginActivity class, inheriting from AppCompatActivity
// It serves as the entry point for the login screen where the user
// enters their credentials
class LoginActivity : AppCompatActivity() {
    private val loginViewModel: LoginViewModel by viewModels()


    // This is where you set up the UI and initialize components
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Find the EditText field for the username in the layout using its ID
        val usernameField = findViewById<EditText>(R.id.username_field)
        //Same function here too, but for the password
        val passwordField = findViewById<EditText>(R.id.password_field)
        //Finds the Button in the activity_login layout that is responsible
        // for submitting the login form
        val loginButton = findViewById<Button>(R.id.login_button)


        //This defines what happens when the user clicks the button.
        loginButton.setOnClickListener {
            // Extract the text entered by the user in the username field
            // and convert it to a String
            val username = usernameField.text.toString()
            //Same function, different field
            val password = passwordField.text.toString()


            //This is to check if both the username and password fields are empty
            if (username.isEmpty() || password.isEmpty()) {
            //This will display the toast message if the username or
                // password has not been filled up
                Toast.makeText(this, "Please enter a username or password", Toast.LENGTH_SHORT)
             .show()
             } else {
            // If both fields are filled, call the login function from the ViewModel
            // by passing in the username and password as arguments
            loginViewModel.login(username, password)
            }
        }


            //Observe the login success LiveData from the LoginViewModel
            // When the login is successful, this observer gets triggered
            loginViewModel.loginSuccess.observe(this) { keypass ->
                // This will start to navigate to the DashboardActivity by
                // creating an intent
                val intent = Intent(this, DashboardActivity::class.java)
                //Pass an extra (key-value pair) with the Intent to share the
                // "keypass" with the Dashboard
                intent.putExtra("keypass", keypass)
                startActivity(intent)
                finish()
            }


            // If an error occurs during login, this observer is triggered.
            loginViewModel.loginError.observe(this) {
                // This shows a toast message, meaning that both of
                // the username and password is wrong
                Toast.makeText(
                    this,
                    "Invalid username or password, please try again",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

