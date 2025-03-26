package com.example.orderapplab4tolab6


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        val inputFood = view.findViewById<EditText>(R.id.input_food)
        val inputQty = view.findViewById<EditText>(R.id.input_qty)
        val btnSubmit = view.findViewById<Button>(R.id.btn_submit)

        btnSubmit.setOnClickListener {
            val food = inputFood.text.toString()
            val qty = inputQty.text.toString()
            val message = "您點了：$food x $qty"

            val bundle = Bundle().apply {
                putString("food", food)
                putString("qty", qty)
            }
            (activity as? MainActivity)?.loadFragment(OrderFragment(), bundle)
        }

        return view
    }
}