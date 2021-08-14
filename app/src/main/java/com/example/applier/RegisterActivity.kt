package com.example.applier

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class RegisterActivity : AppCompatActivity() {
    lateinit var name : EditText
    lateinit var textlogin : EditText
    lateinit var password : EditText
    lateinit var confirmpassword : EditText
    lateinit var register : Button
    lateinit var login : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_register)
        textlogin = findViewById<EditText>(R.id.text_login)
        password = findViewById<EditText>(R.id.text_psw)
        confirmpassword = findViewById<EditText>(R.id.text_conpsw)
        name = findViewById<EditText>(R.id.text_name)
        register = findViewById<Button>(R.id.register)
        login = findViewById<TextView>(R.id.btn_login)


        register.setOnClickListener {
            val login = textlogin.text.toString().trim()
            val password = password.text.toString().trim()
            val confirmpassword = confirmpassword.text.toString().trim()
            val name = name.text.toString().trim()

            val user = User(name, login, password, confirmpassword)
            if (register(user)) {
                save(user)
                startActivity(Intent(this, HelloActivity::class.java))
            }
        }
        login.setOnClickListener {
            finish()
        }
    }


    fun register(user: User): Boolean {
        if (user.login.isEmpty() || user.name.isEmpty() ||
            user.password.isEmpty() || user.confirmpassword.isEmpty()){
            Snackbar
                .make(name,"Bo'sh qoldirmang",Snackbar.LENGTH_LONG)
                .show()
        }
        else if (user.password != user.confirmpassword){
            Snackbar
                .make(name,"Parolni tasdiqlash kerak",Snackbar.LENGTH_LONG)
                .show()
        }
        else{
            return true
        }
        return false
    }

    private fun save(user: User){

        val settings = getSharedPreferences("SETTINGS", Context.MODE_PRIVATE)
        settings.edit()
            .putString("login",user.login)
            .putString("password",user.password)
            .putString("name",user.name)
            apply {  }
    }


}