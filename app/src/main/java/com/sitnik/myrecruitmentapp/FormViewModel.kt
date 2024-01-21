package com.sitnik.myrecruitmentapp

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModel

class FormViewModel : ViewModel() {

    // Expose screen UI state


    // Handle business logic
    fun isEnteredValueValid(enteredValue: String) : Boolean {
        return enteredValue.toDoubleOrNull() != null
    }
}