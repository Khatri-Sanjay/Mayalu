package com.np.sanjaykhatri.merosathi.features.shared.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.np.sanjaykhatri.merosathi.R
import com.np.sanjaykhatri.merosathi.databinding.ItemChatTileBinding
import com.np.sanjaykhatri.merosathi.features.listeners.ChatTileClickListener
import com.np.sanjaykhatri.merosathi.features.shared.model.Chat

class ChatTileViewHolder(
    private val binding: ItemChatTileBinding,
    private val listener: ChatTileClickListener,
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(chat: Chat) {
        binding.txvReceiverName.text = chat.nickname
        Glide.with(binding.root).load(chat.profileUrl)
            .error(R.drawable.mayalu_app_icon)
            .placeholder(R.drawable.mayalu_app_icon).into(binding.imvChatDP)

        itemView.setOnClickListener {
            listener.onChatTileClicked(chat)
        }
    }
}