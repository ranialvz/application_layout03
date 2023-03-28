package com.ralvez.myapplicationlayout02


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.autofill.UserData
import androidx.recyclerview.widget.LinearLayoutManager
import com.ralvez.myapplicationlayout02.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var adapter: Adapter
    private lateinit var list : ArrayList<Info>
    private lateinit var binding : ActivityMainBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.rvBooklist.setHasFixedSize(true)

        list = ArrayList()
        list.add(Info(R.drawable.snowflakes, "Snowflakes"))
        list.add(Info(R.drawable.summer, "Summer"))
        list.add(Info(R.drawable.love, "Love"))
        list.add(Info(R.drawable.lavender, "lavender"))
        list.add(Info(R.drawable.bluemoon, "bluemoon"))

        adapter = Adapter(list)
        binding.rvBooklist.adapter= adapter
        binding.rvBooklist.layoutManager = LinearLayoutManager(this)

        val email = intent.getStringExtra("EXTRA_EMAIL")
        binding.tvInfo.text = email


        binding.btnLogout.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }





    }
}