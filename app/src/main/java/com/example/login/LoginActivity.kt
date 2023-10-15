import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.login.Dashboard
import com.example.login.R
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        auth = FirebaseAuth.getInstance()

        val etEmail = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            // Lakukan proses otentikasi dengan Firebase
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Login berhasil
                        val intent = Intent(this, Dashboard::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        // Login gagal
                        // Tampilkan pesan kesalahan atau tindakan lain yang sesuai
                    }
                }
        }
    }
}
