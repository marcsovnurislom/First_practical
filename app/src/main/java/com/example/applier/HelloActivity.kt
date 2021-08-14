package com.example.applier

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HelloActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)

        val salomtext = findViewById<TextView>(R.id.salomText)

        val user = read()
        salomtext.text = "Salom, ${user.name}"
    }

    private fun read(): User {
        val settings = getSharedPreferences("SETTINGS", Context.MODE_PRIVATE)
        val login = settings.getString("login", "")!!
        val password = settings.getString("password", "")!!
        val name = settings.getString("name", "")!!

        return User(name, login, password, password)
    }
}