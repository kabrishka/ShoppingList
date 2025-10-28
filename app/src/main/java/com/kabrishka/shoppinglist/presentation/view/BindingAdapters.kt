package com.kabrishka.shoppinglist.presentation.view

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout
import com.kabrishka.shoppinglist.R

@BindingAdapter("errorInputName")
fun bindErrorInputName(textInputLayout: TextInputLayout, isError: Boolean) {
    val message = if (isError) textInputLayout.context.getString(R.string.error_input_name) else null
    textInputLayout.error = message
}

@BindingAdapter("errorInputCount")
fun bindErrorInputCount(textInputLayout: TextInputLayout, isError: Boolean) {
    val message = if (isError) textInputLayout.context.getString(R.string.error_input_count) else null
    textInputLayout.error = message
}