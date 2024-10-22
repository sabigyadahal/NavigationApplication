package com.example.NavigationApplication.ui.dashboard

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationapplication.R
import com.example.navigationapplication.R.*
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {

    private val dashboardViewModel: DashboardViewModel by viewModels()
    private lateinit var adapter: EntityAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_dashboard)

        val keypass = intent.getStringExtra("keypass") ?: ""

        adapter = EntityAdapter { entity ->
            // Handle click and navigate to DetailsActivity
        }

        val recyclerView: RecyclerView = findViewById(id.RecyclerViewAdapter)

// Set the LayoutManager and Adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        dashboardViewModel.fetchDashboardData(keypass)

        dashboardViewModel.entities.observe(this) { entities ->
            adapter.submitList(entities)
        }
    }
}
