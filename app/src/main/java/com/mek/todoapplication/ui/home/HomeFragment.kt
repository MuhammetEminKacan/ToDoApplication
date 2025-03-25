package com.mek.todoapplication.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.mek.todoapplication.databinding.FragmentHomeBinding
import com.mek.todoapplication.model.ToDoModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment(),ToDoClickListener {
    private var _binding : FragmentHomeBinding ?= null
    private val binding get() =  _binding!!

    private val viewModel by viewModels<HomeViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.toDoClickListener = this

        viewModel.toDoList.observe(viewLifecycleOwner){
            println(it)
        }

        binding.fragmentHomeFab.setOnClickListener {
            viewModel.insertToDo()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onToDoClick(id: Int) {

    }

    override fun onToDoChecked(toDoModel: ToDoModel) {

    }
}