package com.example.myapplication.activity


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            // EditTextlarni tekshirish
            val allFieldsFilled = validateEditTexts()
            if (allFieldsFilled) {
                // EditTextlar to'ldirilgan bo'lsa, keyingi aktivitiga o'tish
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                // EditTextlar to'ldirilmagan bo'lsa, foydalanuvchuga xabar berish
                // Masalan: Toast xabar yoki qandaydir boshqa xabar berish usuli
                // Misol: to'ldirilmagan EditTextlarga qiziq rang bermoq
                if (!binding.etName.text.isNotEmpty()) {
                    binding.etName.setHintTextColor(Color.RED)
                }
                if (!binding.etEmail.text.isNotEmpty()) {
                    binding.etEmail.setHintTextColor(Color.RED)
                }
                if (!binding.etPassword.text.isNotEmpty()) {
                    binding.etPassword.setHintTextColor(Color.RED)
                }
                if (!binding.etRePassword.text.isNotEmpty()) {
                    binding.etRePassword.setHintTextColor(Color.RED)
                }
                // Misol: foydalanuvchuga qandaydir boshqa xabar berish
                showToast("Iltimos, hamma maydonlarni to'ldiring!")
            }
        }
    }

    // EditTextlarni tekshirish funksiyasi
    private fun validateEditTexts(): Boolean {
        val name = binding.etName.text.toString().trim()
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()
        val rePassword = binding.etRePassword.text.toString().trim()

        // EditTextlarning barchasi to'ldirilganligini tekshirish
        return name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && rePassword.isNotEmpty()
    }

    // Toast xabarini chiqarish uchun funksiya
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
