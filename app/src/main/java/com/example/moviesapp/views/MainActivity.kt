package com.example.moviesapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.moviesapp.R

import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.ui.NavigationUI

import android.view.MenuItem

import androidx.annotation.NonNull



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottomNavView)
        val navController = findNavController(R.id.navHostMain)

        //To change action bar title
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment,R.id.favouritesFragment,R.id.accountFragment))
        setupActionBarWithNavController(navController,appBarConfiguration)

        bottomNavView.setupWithNavController(navController)
    }
}