package com.sitnik.myrecruitmentapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController


class FormFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val resultText = view.findViewById<EditText>(R.id.editTextNumberDecimal)
        val viewModel: FormViewModel by viewModels()


        view.findViewById<Button>(R.id.validateButton).setOnClickListener {

            val isValid  = viewModel.isEnteredValueValid(resultText.text.toString())
            if (isValid) {
                view.findViewById<TextView>(R.id.textView).setText("Poprawna walidacja")
                view.findViewById<Button>(R.id.showNextScreenButton).isEnabled = true
            } else {
                view.findViewById<TextView>(R.id.textView).setText("Nie poprawna walidacja")
                view.findViewById<Button>(R.id.showNextScreenButton).isEnabled = false
            }
        }

        // navigate from button 'Show next screen' to ResultFragment - 2nd screen
        view.findViewById<Button>(R.id.showNextScreenButton).setOnClickListener {
            val amount = resultText.text.toString() // wyciąga cyfrę wpisaną w editTextNumberDecimal
            val action = FormFragmentDirections.actionFormFragmentToResultFragment(amount) // navigates from button 'Show next screen' to ResultFragment - 2nd screen
            findNavController().navigate(action) // wywołanie akcji
        }
    }
}