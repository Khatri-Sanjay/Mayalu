package com.np.sanjaykhatri.merosathi.utils.util

import android.view.View
import com.np.sanjaykhatri.merosathi.databinding.ItemProgressButtonBinding

fun ItemProgressButtonBinding.showProgress() {
    this.prbButton.visibility = View.VISIBLE
}

fun ItemProgressButtonBinding.hideProgress() {
    this.prbButton.visibility = View.GONE
}