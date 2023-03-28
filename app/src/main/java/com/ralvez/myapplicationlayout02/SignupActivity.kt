package com.ralvez.myapplicationlayout02

import android.content.Intent
import android.os.Bundle
import android.service.autofill.UserData
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.ralvez.myapplicationlayout02.databinding.ActivitySignupBinding



class SignupActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySignupBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.btnSignup.setOnClickListener {
            //MyDataSingleton.myDataList.add(MyData("juan","crus","juan5@gmail.com","test1122"))

            val fname= binding.etFName.text.toString()
            val lname= binding.etLName.text.toString()
            val email= binding.etEmail.text.toString()
            val password= binding.etPass.text.toString()
            val passwordC= binding.etPassC.text.toString()

            if (fname.isNullOrEmpty() || lname.isNullOrEmpty() ||  email.isNullOrEmpty() ||  password.isNullOrEmpty() ){
                val toast = Toast.makeText(this, "Pls fill up form must not be empty", Toast.LENGTH_SHORT)
                toast.setGravity(0, 0, 0)
                toast.show()
            } else {
                if (password == passwordC) {
                    MyDataSingleton.myDataList.add(MyData(fname, lname, email, password))
                    val toast = Toast.makeText(this, "Success SignUp", Toast.LENGTH_SHORT)
                    toast.show()
                    Intent(this, SuccessRActivity::class.java).also {
                        it.putExtra("EXTRA_LNAME", lname)
                        it.putExtra("EXTRA_FNAME", fname)
                        it.putExtra("EXTRA_EMAIL", email)
                        startActivity(it)
                    }
                    }else{
                        val toast = Toast.makeText(this, "Confirm password is not equal", Toast.LENGTH_SHORT)
                        toast.show()


                    }
            }

        }
        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
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


