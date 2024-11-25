package com.example.sprint5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurar el Toolbar como ActionBar
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Configurar la navegación
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainer) as NavHostFragment
        val navController = navHostFragment.navController

        // Configurar el Toolbar para la navegación
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = (supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment).navController
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}