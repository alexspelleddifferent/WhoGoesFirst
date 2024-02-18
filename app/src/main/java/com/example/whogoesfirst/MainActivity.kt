package com.example.whogoesfirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    //initialization of elements
    private lateinit var select_one: EditText
    private lateinit var select_two: EditText
    private lateinit var random_button: Button
    private lateinit var selection: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //assignment of elements to variables
        select_one = findViewById(R.id.input_field1)
        select_two = findViewById(R.id.input_field2)
        random_button = findViewById(R.id.random_button)
        selection = findViewById(R.id.selection)

        //set button click listener: grab text input of two entry fields, if either is empty warn
        //the user, otherwise select a random number between 0 or 1 then select one of the options
        //and make it as the text of the textview element
        random_button.setOnClickListener{
            val select_one_text = select_one.text
            val select_two_text = select_two.text
            if (select_one_text.isEmpty()||select_two_text.isEmpty()) {
                //reset textview
                selection.text = getString(R.string.selection_text)
                Toast.makeText(this, "Please enter two options", Toast.LENGTH_SHORT).show()
            } else {
                //get random number between 0 or 1
                val rnds = (0..1).random()
                if (rnds==0) {
                    selection.text = select_one_text
                } else {
                    selection.text = select_two_text
                }
            }
        }
    }
}