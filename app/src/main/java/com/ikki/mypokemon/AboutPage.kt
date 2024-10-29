package com.ikki.mypokemon

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AboutPage: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_me)

        val tvTrainerName: TextView = findViewById(R.id.tv_trainer_name)
        val tvTrainerID: TextView = findViewById(R.id.tv_trainer_id)
        val tvTrainerEmail: TextView = findViewById(R.id.tv_trainer_email)

        tvTrainerName.text = getString(R.string.trainer_name, getString(R.string.my_name))
        tvTrainerID.text = getString(R.string.trainer_id, getString(R.string.my_id))
        tvTrainerEmail.text = getString(R.string.trainer_email, getString(R.string.my_email))
    }
}