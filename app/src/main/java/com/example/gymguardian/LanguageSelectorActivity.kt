package com.example.gymguardian

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale
import android.content.Context

class LanguageSelectorActivity : AppCompatActivity() {

    override fun attachBaseContext(newBase: Context) {
        val lang = LocaleHelper.getSavedLanguage(newBase) ?: Locale.getDefault().language
        val context = LocaleHelper.setLocale(newBase, lang)
        super.attachBaseContext(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.language_selector)

        val englishButton: Button = findViewById(R.id.englishButton)
        val spanishButton: Button = findViewById(R.id.spanishButton)

        englishButton.setOnClickListener {
            changeLanguage("en")
        }

        spanishButton.setOnClickListener {
            changeLanguage("es")
        }

        //back arrow
        val backArrow = findViewById<ImageView>(R.id.backArrow)
        backArrow.setOnClickListener {
            finish() // Regresa a la actividad anterior (MainActivity)
        }
    }

    private fun changeLanguage(languageCode: String) {
        LocaleHelper.setLocale(this, languageCode)

        // Restart the app to apply the change
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}
