package com.example.respire

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.respire.databinding.ActivityLandingBinding
import com.example.respire.databinding.ActivityMainBinding

class Landing : AppCompatActivity() {
    lateinit var landingBinding: ActivityLandingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        landingBinding = ActivityLandingBinding.inflate(layoutInflater)
        setContentView(landingBinding.root)

        landingBinding.mainnavview.background=null
        landingBinding.mainnavview.menu.getItem(2).isEnabled=false

        replacefragment(Home())

        landingBinding.plantripbtn.setOnClickListener{
            val intent = Intent(this@Landing, MainActivity::class.java)
            startActivity(intent)
        }

        landingBinding.mainnavview.setOnItemSelectedListener{
            when(it.itemId) {
                R.id.homebtn -> replacefragment(Home())
                R.id.friendbtn -> replacefragment(Trending())
                R.id.profilebtn -> replacefragment(Profile())
                R.id.searchbtn -> replacefragment(Device())

            }
            true
        }
    }

    private fun replacefragment(fragment : Fragment){

        val fragmentManager=supportFragmentManager
        val fragmentTransection=fragmentManager.beginTransaction()
        fragmentTransection.replace(R.id.fragmentcontainer,fragment)

        fragmentTransection.commit()

    }
}