package com.np.sanjaykhatri.merosathi.utils.util

import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.setCustomError(errorMessage: String) {
    this.error = errorMessage
}

fun TextInputLayout.removeError() {
    this.error = null
    this.isErrorEnabled = false
}