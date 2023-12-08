package com.np.sanjaykhatri.merosathi.features.listeners

import com.np.sanjaykhatri.merosathi.features.shared.model.User

interface SwipeCardOnClickListener {
    fun onLikeButtonClicked(user: User)
    fun onDislikeButtonClicked()
    fun onSwipeCardClicked(user: User)
}