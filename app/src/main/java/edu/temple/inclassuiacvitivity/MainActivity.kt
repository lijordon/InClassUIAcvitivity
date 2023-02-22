package edu.temple.inclassuiacvitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val changeButton = findViewById<Button>(R.id.changeButton)
        val displayTextView = findViewById<TextView>(R.id.textDisplay)

        // Step 1: Populate array
        val numberArray = IntArray(100)
        var arrayTemp = 1
        for (index in 0..99) {
            numberArray[index] = arrayTemp
            arrayTemp++
        }

        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, numberArray.asList())


        // Step 2: Save selected text size
        var textSize = 1
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                textSize = numberArray[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Step 3: Change TextView to saved text size
        changeButton.setOnClickListener {
            displayTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP,textSize.toFloat())
        }

    }
}