package com.picpay.desafio.android.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.picpay.desafio.android.R
import com.picpay.desafio.android.data.model.response.UserResponse
import com.picpay.desafio.android.databinding.ActivityMainBinding
import com.picpay.desafio.android.presentation.viewModel.MainViewModel
import com.picpay.desafio.android.presentation.viewModel.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val adapter = UserListAdapter()
    private val viewModel: MainViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListener()
        initObserver()
    }

    private fun setListener() {
        getUsers()
    }

    private fun initObserver() {
        viewModel.getAllUsersViewState.observe(this) { viewState ->
            when (viewState) {
                is ViewState.LOADING -> {
                    binding.userListProgressBar.visibility = View.VISIBLE
                }
                is ViewState.SUCCESS -> {
                    binding.userListProgressBar.visibility = View.GONE
                    viewState.data?.let {
                        setupAdapter(it)
                    }
                }
                is ViewState.ERROR -> {
                    //TODO - add uma view de error
                }
            }
        }
    }

    private fun setupAdapter(listUser: List<UserResponse>) {
        adapter.users = listUser
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun getUsers() {
        viewModel.getUsers()
    }

}
