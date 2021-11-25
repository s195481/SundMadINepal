package com.example.sundmadinepal.ui.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.sundmadinepal.databinding.FragmentHomeBinding

class RecipeFragment : Fragment() {

    private lateinit var recipeViewModel: RecipeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        recipeViewModel =
                ViewModelProvider(this).get(RecipeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        recipeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        /*println("Going back");
        activity?.onBackPressed();*/
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}