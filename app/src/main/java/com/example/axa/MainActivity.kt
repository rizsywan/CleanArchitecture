package com.example.axa

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.axa.core.data.AxaRepository
import com.example.axa.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels { AxaViewModelFactory(AxaRepository()) }
    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var adapter: AxaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the view binding
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root) // Gunakan viewBinding.root di sini

        adapter = AxaAdapter()
        with(viewBinding) {
            rv.layoutManager = LinearLayoutManager(this@MainActivity)
            rv.adapter = adapter
        }

        viewModel.data.observe(this) { data ->
            adapter.submitList(data)
        }
    }
}