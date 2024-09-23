package com.example.sanpa

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project135.domain.TrendsDomian
import com.example.sanpa.Adapter.TrendsAdapter

class DashBoard : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TrendsAdapter
    private lateinit var trends: List<TrendsDomian>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dash_board)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set up RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Sample data for RecyclerView
        trends = listOf(
            TrendsDomian("Hire Constructors", "We will help you find the best constructors the best in the business", R.drawable.img_constructors),
            TrendsDomian("View Construction Sites", "Here In Sanpa Construction we have secured best building sites at affordable prices", R.drawable.img_sites
            ),
            TrendsDomian("Designs", "In Sanpa Construction we make it easy for you to find you a designer best in the business. To make you dream home come to life", R.drawable.img_designs),
            TrendsDomian("Vehicles", "We offer the best machinery to help you build.  The vehicles are for hire at a fixed price.", R.drawable.img_vehcles),
            TrendsDomian("Tools", "Sanpa will help you find the best equipments to aid in you project.  The tools are for hire at a fixed price.", R.drawable.img_tools)
        )

        adapter = TrendsAdapter(trends)
        recyclerView.adapter = adapter
    }

    // Inflate the menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    // Handle menu item clicks
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_notificactions -> {
                Toast.makeText(this, "Notifications clicked", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_settings -> {
                Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_logout -> {
                Toast.makeText(this, "Logout clicked", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
