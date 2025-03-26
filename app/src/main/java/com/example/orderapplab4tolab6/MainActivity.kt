package com.example.orderapplab4tolab6

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    private val tag = "MainActivityLifecycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(tag, "onCreate called")
        loadFragment(MenuFragment())
    }

    fun loadFragment(fragment: Fragment, bundle: Bundle? = null) {
        fragment.arguments = bundle
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

    fun showConfirmationDialog(message: String) {
        AlertDialog.Builder(this)
            .setTitle("訂單確認")
            .setMessage(message)
            .setPositiveButton("確定", null)
            .show()
    }
}
