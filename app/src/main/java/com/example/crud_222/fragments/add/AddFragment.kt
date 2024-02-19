package com.example.crud_222.fragments.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.crud_222.R
import com.example.crud_222.model.User
import com.example.crud_222.viewmodel.UserViewModel

class addFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel
    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        rootView = view

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        val addButton: Button = view.findViewById(R.id.button)

        addButton.setOnClickListener {
            insertDataToDatabase()
            findNavController().popBackStack()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val primeiroNomeEditText: EditText = rootView.findViewById(R.id.editTextText)
        val primeiroNome = primeiroNomeEditText.text.toString()

        val sobrenomeEditText: EditText = rootView.findViewById(R.id.editTextText6)
        val sobrenome = sobrenomeEditText.text.toString()

        val idadeEditText: EditText = rootView.findViewById(R.id.editTextText7)
        val idade = idadeEditText.text.toString()

        val user = User(id = 0, primeiroNome, sobrenome, if (idade.isNotEmpty()) Integer.parseInt(idade) else 0)

        mUserViewModel.addUser(user)
        Toast.makeText(requireContext(), "Adicionado com sucesso", Toast.LENGTH_LONG).show()
    }
}
