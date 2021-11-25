package urraan.internship.nav_component

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.navigation.Navigation

class FirstFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        // Inflate the layout for this fragment
        val button = view.findViewById(R.id.btn_navigateToSecond) as ImageButton
        button.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_firstFragment_to_secondFragment)
        }
        return view

    }


}