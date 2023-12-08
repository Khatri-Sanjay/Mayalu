package com.np.sanjaykhatri.merosathi.features.listeners

import com.np.sanjaykhatri.merosathi.features.shared.model.Chat

interface ChatTileClickListener {
    fun onChatTileClicked(chat: Chat)
}