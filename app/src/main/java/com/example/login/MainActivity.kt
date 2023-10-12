package com.example.login

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast as Toast1


class MainActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var button: Button

    @SuppressLint("MissingInflatedId")
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.usernameEditText = findViewById(R.id.etUsername)
        this.passwordEditText = findViewById(R.id.etPassword)
        this.button = findViewById(R.id.Button)

        button.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

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
