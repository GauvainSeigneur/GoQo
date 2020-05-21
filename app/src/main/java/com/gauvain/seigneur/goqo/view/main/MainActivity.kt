package com.gauvain.seigneur.goqo.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gauvain.seigneur.goqo.R
import com.gauvain.seigneur.goqo.presentation.data.UserItemData
import com.gauvain.seigneur.goqo.presentation.viewmodel.MainViewModel
import com.gauvain.seigneur.goqo.view.details.DetailsActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(),
    RandomUsersListAdapter.Listener {


    private val viewModel: MainViewModel by viewModel()
    private lateinit var adapter: RandomUsersListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initAdapter()
        viewModel.fetchUsersFromService()
        viewModel.usersList?.observe(this, Observer {
            adapter.submitList(it)
        })
    }

    override fun onClick(data: UserItemData?) {
        data?.let {
            startActivity(DetailsActivity.newIntent(this, it))
        }
    }

    private fun initAdapter() {
        adapter = RandomUsersListAdapter(this)
        usersRecyclerView.layoutManager = LinearLayoutManager(
            this, RecyclerView.VERTICAL,
            false
        )
        usersRecyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )
        usersRecyclerView.adapter = adapter
    }

}
