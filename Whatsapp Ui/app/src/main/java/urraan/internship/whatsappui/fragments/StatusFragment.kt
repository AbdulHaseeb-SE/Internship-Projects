package urraan.internship.whatsappui.fragments

import android.animation.ObjectAnimator
import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton
import urraan.internship.whatsappui.R
import android.view.animation.AnimationUtils
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import urraan.internship.whatsappui.MainViewModel
import urraan.internship.whatsappui.adapters.StatusListAdapter
import urraan.internship.whatsappui.databinding.FragmentStatusBinding


class StatusFragment : Fragment(R.layout.fragment_status) {
    private lateinit var binding: FragmentStatusBinding
    private lateinit var viewModel: MainViewModel
    var fabEdit: FloatingActionButton? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_status, container, false)
        fabEdit = view.findViewById(R.id.fabWriteText) as FloatingActionButton
        animateButton(fabEdit!!, -140f)
        // Inflate the layout for this fragment
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentStatusBinding.bind(view)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        val listStatus = viewModel.getStatusList(requireContext())

        val adapter = StatusListAdapter(listStatus)
        binding.recyclerViewStatuses.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun animateButton(fabEdit: FloatingActionButton, animation : Float){
        ObjectAnimator.ofFloat(fabEdit, "translationY", animation).apply {
            duration = 300
            start()
        }
    }

    override fun onPause() {
        super.onPause()
       animateButton(fabEdit!!, 0f)
    }

    override fun onResume() {
        super.onResume()
        animateButton(fabEdit!!, -140f)
    }
}