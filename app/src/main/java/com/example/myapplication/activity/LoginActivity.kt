package com.example.myapplication.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.signUp.setOnClickListener {
            startActivity(Intent(this@LoginActivity,MainActivity::class.java))
            finish()
        }
        binding.btnRegister.setOnClickListener {
            // EditTextlarni tekshirish
            val allFieldsFilled = validateEditTexts()
            if (allFieldsFilled) {
                // EditTextlar to'ldirilgan bo'lsa, keyingi aktivitiga o'tish
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                // EditTextlar to'ldirilmagan bo'lsa, foydalanuvchuga xabar berish
                // Misol: Toast xabar yoki qandaydir boshqa xabar berish usuli
                showToast("Iltimos, hamma maydonlarni to'ldiring!")
            }
        }
    }

    // EditTextlarni tekshirish funksiyasi
    private fun validateEditTexts(): Boolean {
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()

        // EditTextlarning barchasi to'ldirilganligini tekshirish
        return email.isNotEmpty() && password.isNotEmpty()
    }

    // Toast xabarini chiqarish uchun funksiya
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}