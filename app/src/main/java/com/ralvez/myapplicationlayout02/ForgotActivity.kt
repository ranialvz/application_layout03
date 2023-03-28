package com.ralvez.myapplicationlayout02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ralvez.myapplicationlayout02.databinding.ActivityForgotBinding


class ForgotActivity : AppCompatActivity() {
    private lateinit var binding : ActivityForgotBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener {
            val email= binding.etEmail.text.toString()
            if (email.isNullOrEmpty() ) {
                val toast = Toast.makeText(this, "Please Input Email Address", Toast.LENGTH_SHORT)
                toast.setGravity(0, 0, 0)
                toast.show()
            } else {
                val mydata = MyDataSingleton.myDataList.find{it.email == email}?.toString()

                if (mydata.isNullOrEmpty()) {
                    val toast = Toast.makeText(this, "Invalid Email", Toast.LENGTH_SHORT)
                    toast.setGravity(0, 0, 0)
                    toast.show()
                }else{
                    Intent(this, LoginActivity::class.java).also {
                        startActivity(it)
                    }

                    val toast = Toast.makeText(this, "Change Password! Please Check Email", Toast.LENGTH_SHORT)
                    toast.setGravity(0, 0, 0)
                    toast.show()
                }

            }


        }
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "Back"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true


    }


}