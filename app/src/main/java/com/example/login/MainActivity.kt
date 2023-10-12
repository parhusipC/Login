package com.example.login

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast as Toast1


class MainActivity : AppCompatActivity() {

    private lateinit var UsernameEditText: EditText
    private lateinit var PasswordEditText: EditText
    private lateinit var Button: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.UsernameEditText = findViewById(R.id.etUsername)
        this.PasswordEditText = findViewById(R.id.etPassword)
        this.Button = findViewById(R.id.Button)

        Button.setOnClickListener {
            val username = UsernameEditText.text.toString()
            val password = PasswordEditText.text.toString()

            if (isLoginValid(username, password)) {
                // Login berhasil
                val intent = Intent(this, Dashboard::class.java)
                startActivity(intent)
                finish()
            } else {
                // Login gagal
                Toast1.makeText(this, "Login gagal. Silakan coba lagi.", Toast1.LENGTH_SHORT).show()
            }
        }
    }

    private fun isLoginValid(username: String, password: String): Boolean {
        // Di sini Anda dapat menambahkan logika validasi login sesuai dengan kebutuhan Anda.
        // Contoh sederhana: jika username dan password adalah "admin", maka dianggap berhasil.
        return username == "carlosparhusip03@gmail.com" && password == "hutabarat123"
    }
}
