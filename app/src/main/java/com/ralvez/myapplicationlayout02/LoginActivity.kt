package com.ralvez.myapplicationlayout02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ralvez.myapplicationlayout02.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            //MyDataSingleton.myDataList.add(MyData("juan","crus","juan@gmail.com","test1122"))
            val email= binding.etEmail.text.toString()
            val password= binding.etPass.text.toString()

            if (email.isNullOrEmpty() ||  password.isNullOrEmpty() ){
                val toast = Toast.makeText(this, "Please Input Email and Password", Toast.LENGTH_SHORT)
                toast.setGravity(0, 0, 0)
                toast.show()
            } else {
                val mydata = MyDataSingleton.myDataList.find{it.email == email && it.password == password }?.toString()

                if (mydata.isNullOrEmpty()) {
                    val toast = Toast.makeText(this, "Invalid Email and Password", Toast.LENGTH_SHORT)
                    toast.setGravity(0, 0, 0)
                    toast.show()
                }else{
                    Intent(this, MainActivity::class.java).also {
                        it.putExtra("EXTRA_EMAIL", email)
                       startActivity(it)
                    }

                    val toast = Toast.makeText(this, "Success Login", Toast.LENGTH_SHORT)
                    toast.setGravity(0, 0, 0)
                    toast.show()
                }

            }
        }
        binding.tvSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        binding.tvForgot.setOnClickListener {
            val intent = Intent(this, ForgotActivity::class.java)
            startActivity(intent)
        }


    }
}