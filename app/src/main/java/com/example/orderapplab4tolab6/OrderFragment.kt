package com.example.orderapplab4tolab6


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class OrderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_order, container, false)

        val textSummary = view.findViewById<TextView>(R.id.order_summary)
        val btnBack = view.findViewById<Button>(R.id.btn_back)
        val btnConfirm = view.findViewById<Button>(R.id.btn_confirm)

        val food = arguments?.getString("food") ?: ""
        val qty = arguments?.getString("qty") ?: "0"
        val total = qty.toIntOrNull()?.times(50) ?: 0 // 單價假設 50

        textSummary.text = "訂單內容：$food x $qty\n總金額：$total 元"

        btnBack.setOnClickListener {
            (activity as? MainActivity)?.loadFragment(MenuFragment())
        }

        btnConfirm.setOnClickListener {
            (activity as? MainActivity)?.showConfirmationDialog("訂單已送出，感謝您的購買！")
        }

        return view
    }
}
