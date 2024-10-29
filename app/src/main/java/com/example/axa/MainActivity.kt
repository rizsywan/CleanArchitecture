package com.example.axa

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.axa.core.data.remote.network.ApiResponse
import com.example.axa.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var adapter: AxaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the view binding
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        adapter = AxaAdapter()
        with(viewBinding) {
            rv.layoutManager = LinearLayoutManager(this@MainActivity)
            rv.adapter = adapter
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.dataFlow.collect{
                    when(it) {
                        ApiResponse.Empty -> {
                            Snackbar.make(viewBinding.root, "data kosong", Snackbar.LENGTH_SHORT).show()
                        }
                        is ApiResponse.Error -> {
                            Snackbar.make(viewBinding.root, it.errorMessage, Snackbar.LENGTH_SHORT).show()
                        }
                        is ApiResponse.Success -> {
                            adapter.submitList(it.data)
                        }
                    }
                }
            }
        }
    }
}