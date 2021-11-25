package urraan.internship.whatsappui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import urraan.internship.whatsappui.MainViewModel
import urraan.internship.whatsappui.R
import urraan.internship.whatsappui.adapters.ChatListAdapter
import urraan.internship.whatsappui.databinding.FragmentChatBinding

class ChatFragment : Fragment(R.layout.fragment_chat) {
    private lateinit var binding: FragmentChatBinding
    private lateinit var viewModel: MainViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentChatBinding.bind(view)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        val list = viewModel.getChatList(requireContext())

        val adapter = ChatListAdapter(list)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
}