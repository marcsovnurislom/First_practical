package com.example.applier

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var textlogin: EditText
    lateinit var password: EditText
    lateinit var register: TextView
    lateinit var login: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)
        textlogin = findViewById<EditText>(R.id.text_login)
        password = findViewById<EditText>(R.id.text_password)
        register = findViewById<TextView>(R.id.register)
        login = findViewById<Button>(R.id.btn_login)


        login.setOnClickListener {
            val login = textlogin.text.toString().trim()
            val password = password.text.toString().trim()
            if (login(login,password)) {
                startActivity(Intent(this,HelloActivity::class.java))
            }
        }
        register.setOnClickListener{
            startActivity(Intent(this,RegisterActivity::class.java))
        }
    }


    fun login(login: String, password: String): Boolean {
        if (login.isEmpty() || password.isEmpty()) {
            Snackbar.make(textlogin, "Bo'sh qoldirmang", Snackbar.LENGTH_LONG).show()
        } else {
            val user = read()
            if (user.password != password || user.login != login) {
                Snackbar
                    .make(textlogin, "Login yoki parol hato kiritilgan", Snackbar.LENGTH_LONG).show()
            }
            else{
                return true
            }
        }
        return false
    }
    private fun read(): User {
        val settings = getSharedPreferences("SETTINGS", Context.MODE_PRIVATE)
        val login = settings.getString("login", "")!!
        val password = settings.getString("password", "")!!
        val name = settings.getString("name", "")!!

        return User(name, login, password, password)
    }
}