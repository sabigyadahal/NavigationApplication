package com.example.NavigationApplication.ui.details

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.NavigationApplication.Entity
import com.example.navigationapplication.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val entity: Entity? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("entity", Entity::class.java)
        } else {
            @Suppress("DEPRECATION")  // Suppress the deprecation warning for older APIs
            intent.getParcelableExtra("entity")
        }

// Assuming you are using findViewById (replace with ViewBinding if applicable)
        val property1TextView: TextView = findViewById(R.id.property1_TextView)
        val property2TextView: TextView = findViewById(R.id.property2TextView)
        val descriptionTextView: TextView = findViewById(R.id.descriptionTextView)

// Assigning the values if entity is not null
        entity?.let {
            property1TextView.text = it.property1
            property2TextView.text = it.property2
            descriptionTextView.text = it.description
        }
}}
