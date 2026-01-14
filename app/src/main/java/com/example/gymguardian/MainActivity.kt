package com.example.gymguardian

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale
import android.content.Context
import android.content.Intent


class MainActivity : AppCompatActivity() {
    override fun attachBaseContext(newBase: Context) {
        val savedLang = LocaleHelper.getSavedLanguage(newBase)
        val lang = savedLang ?: Locale.getDefault().language
        
        if (savedLang == null) {
            LocaleHelper.setLocale(newBase, lang)
        }

        val context = LocaleHelper.setLocale(newBase, lang)
        super.attachBaseContext(context)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton: Button = findViewById(R.id.startButton)
        val signInTextView: TextView = findViewById(R.id.signInTextView)
        val changeLanguageButton: Button = findViewById(R.id.changeLanguageButton)

        //"Start"
        startButton.setOnClickListener {

            // Mensaje temporal
            Toast.makeText(this, "Aun no hace nada jeje", Toast.LENGTH_SHORT).show()
        }

        //"Sign in"
        signInTextView.setOnClickListener {

            //Mensaje temporal
            Toast.makeText(this, "Aun no hace nada x2 jeje", Toast.LENGTH_SHORT).show()
        }

        changeLanguageButton.setOnClickListener {
            val intent = Intent(this, LanguageSelectorActivity::class.java)
            startActivity(intent)
        }
    }
}