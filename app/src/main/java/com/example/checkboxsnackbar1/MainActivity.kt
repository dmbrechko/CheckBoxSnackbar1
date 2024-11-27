package com.example.checkboxsnackbar1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.checkboxsnackbar1.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
        binding.apply {
            saveBTN.setOnClickListener {
                if (inputET.text.toString().isNotBlank()) {
                    outputTV.text = inputET.text.toString()
                } else {
                    Snackbar.make(saveBTN, getString(R.string.enter_data), Snackbar.LENGTH_SHORT).show()
                }
            }
            deleteBTN.setOnClickListener {
                if (outputTV.text.toString().isNotBlank()) {
                    Snackbar.make(deleteBTN, getString(R.string.confirm_deleting), Snackbar.LENGTH_SHORT)
                        .setAction(R.string.delete) {
                            outputTV.text = ""
                            Snackbar.make(deleteBTN, R.string.data_deleted, Snackbar.LENGTH_SHORT).show()
                        }
                        .show()
                } else {
                    Snackbar.make(deleteBTN, getString(R.string.save_first), Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }
}