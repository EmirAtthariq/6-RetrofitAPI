package com.motion.jokes

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    // assign mSelectedCategory variable with default value "animal"
    private var mSelectedCategory: String = "animal"
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_jokes: Button = findViewById(R.id.btn_getjokes)
        val tv_jokes: TextView = findViewById(R.id.tv_jokess)
        val mprogressBar: ProgressBar = findViewById(R.id.idLoadingPB)
        // assign lastCheckedId variable with default value 0
        var lastCheckedId = 0
        // Set the click listener for the Get Jokes button
        btn_jokes.setOnClickListener {
            val radioGroup = findViewById<RadioGroup>(R.id.radiogroup_category)
            // Show the progress bar
            mprogressBar.visibility = View.VISIBLE
            // Set the onCheckedChanged listener for the radio group
            radioGroup.setOnCheckedChangeListener { _, checkedId ->
                // If the checked radio button is
                // different from the last one
                if (checkedId != lastCheckedId) {
                    // Update the lastCheckedId variable
                    lastCheckedId = checkedId
                    val radioButton = findViewById<RadioButton>(checkedId)
                    // Update the mSelectedCategory variable with
                    // the selected radio button's text
                    mSelectedCategory = radioButton.text.toString()
                }
            }
            // Call the API to get a random joke
            // based on the selected category
            ApiCall().getRandomJoke(mSelectedCategory!!) { joke ->
                // Set the text of the TextView to the joke value
                tv_jokes.text = joke?.value
                // Hide the progress bar
                mprogressBar.visibility = View.GONE
            }
        }
    }
}