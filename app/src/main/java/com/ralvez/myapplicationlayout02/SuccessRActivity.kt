package com.ralvez.myapplicationlayout02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ralvez.myapplicationlayout02.databinding.ActivitySuccessRBinding

class SuccessRActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySuccessRBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuccessRBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mydata = MyDataSingleton.myDataList
        //val mydata = MyDataSingleton.myDataList.find{it.email == "juan5@gmail.com"}




        val fname = intent.getStringExtra("EXTRA_FNAME")
        val lname = intent.getStringExtra("EXTRA_LNAME")
        val email = intent.getStringExtra("EXTRA_EMAIL")

        val user = "Name: $fname $lname \nEmail: $email"

        binding.tvEmail.text = mydata.toString()

        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Back"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true


    }
}