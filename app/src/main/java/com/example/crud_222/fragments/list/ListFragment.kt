package com.example.crud_222.fragments.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crud_222.R
import com.example.crud_222.model.User
import com.example.crud_222.viewmodel.UserViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton

class listFragment : Fragment(), ListAdapter.OnEditClickListener {

    private lateinit var mUserViewModel: UserViewModel
    private lateinit var adapter: ListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        adapter = ListAdapter(this)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
            adapter.setData(user)
        })

        view.findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener {
            findNavController().navigate(R.id.addFragment)
        }


        view.findViewById<FloatingActionButton>(R.id.deleteButton).setOnClickListener {
            mUserViewModel.deleteAllUsers()
        }


        return view
    }



    override fun onEditClick(user: User) {
    }
}
