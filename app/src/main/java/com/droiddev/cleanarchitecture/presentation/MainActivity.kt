package com.droiddev.cleanarchitecture.presentation

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.droiddev.cleanarchitecture.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val vm by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etText = findViewById<TextView>(R.id.textView)
        val eEdit = findViewById<EditText>(R.id.editTextTextPersonName)
        val buttonGet = findViewById<TextView>(R.id.button)
        val buttonSave = findViewById<TextView>(R.id.button2)

        vm.resultLive.observe(this, {
            etText.text = it
        })
        buttonSave.setOnClickListener {
            val text = eEdit.text.toString()
            vm.save(text)
        }

        buttonGet.setOnClickListener {
            vm.load()
        }
    }
}