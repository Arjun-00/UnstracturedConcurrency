package com.posibolt.unstracturedconcurrency

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button = findViewById<Button>(R.id.button)
        var textView = findViewById<TextView>(R.id.textView)

        button.setOnClickListener {
            CoroutineScope(Main).launch {
                var value = UnstructerdConcurrency().calculation().toString()
                //var value = StructuredConcurrency().calculate().toString()
                textView.text = value.toString()
            }
        }

    }
}