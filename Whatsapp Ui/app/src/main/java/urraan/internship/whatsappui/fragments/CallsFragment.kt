package urraan.internship.whatsappui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import urraan.internship.whatsappui.MainViewModel
import urraan.internship.whatsappui.R
import urraan.internship.whatsappui.adapters.CallListAdapter
import urraan.internship.whatsappui.databinding.CallsListItemBinding
import urraan.internship.whatsappui.databinding.FragmentCallsBinding


class CallsFragment : Fragment() {
    private lateinit var binding: FragmentCallsBinding
    private lateinit var viewModel : MainViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCallsBinding.bind(view)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        val listCalls = viewModel.getCallData(requireContext())

        val adapter = CallListAdapter(listCalls)
        binding.recyclerViewCall.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}