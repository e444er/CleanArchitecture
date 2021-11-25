package com.droiddev.cleanarchitecture.presentation

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.droiddev.cleanarchitecture.R
import com.droiddev.cleanarchitecture.app.App
import org.koin.androidx.viewmodel.ext.android.viewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var vmFactory: MainViewModelFactory

    private lateinit var vm :MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as App).appComponent.inject(this)

        vm = ViewModelProvider(this, vmFactory)
        .get(MainViewModel::class.java)

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