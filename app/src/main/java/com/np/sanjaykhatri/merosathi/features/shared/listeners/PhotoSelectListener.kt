package com.np.sanjaykhatri.merosathi.features.shared.listeners

import com.np.sanjaykhatri.merosathi.features.shared.model.Photo

interface PhotoSelectListener {
    fun getSelectedPhoto(photo: Photo)
}