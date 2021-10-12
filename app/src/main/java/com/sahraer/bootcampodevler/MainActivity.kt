package com.sahraer.bootcampodevler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sahraer.bootcampodevler.uitasarim.BuyScreenFragment
import com.sahraer.bootcampodevler.uitasarim.ChatScreenFragment
import com.sahraer.bootcampodevler.uitasarim.HomeScreenFragment
import com.sahraer.bootcampodevler.uitasarim.SignScreenFragment

class MainActivity : AppCompatActivity() {

    private val bottomNavigationView by lazy {findViewById<BottomNavigationView>(R.id.bottom_navigation)}
    private val signFragment = SignScreenFragment()
    private val homeFragment = HomeScreenFragment()
    private val buyFragment = BuyScreenFragment()
    private val chatFragment = ChatScreenFragment()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setCurrentFragment(homeFragment)

        bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.home->setCurrentFragment(homeFragment)
                R.id.activity->setCurrentFragment(signFragment)
                R.id.buy -> setCurrentFragment(buyFragment)
                R.id.chat -> setCurrentFragment(chatFragment)


            }
            true
        }


    }


    private fun setCurrentFragment(fragment:Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container,fragment)
            commit()
        }



}