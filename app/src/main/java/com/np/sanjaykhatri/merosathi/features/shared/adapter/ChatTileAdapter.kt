package com.np.sanjaykhatri.merosathi.features.shared.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.np.sanjaykhatri.merosathi.databinding.ItemChatTileBinding
import com.np.sanjaykhatri.merosathi.features.listeners.ChatTileClickListener
import com.np.sanjaykhatri.merosathi.features.shared.model.Chat
import com.np.sanjaykhatri.merosathi.features.shared.viewholder.ChatTileViewHolder

class ChatTileAdapter(
    private val chatList: MutableList<Chat>,
    private val listener: ChatTileClickListener,
) :
    RecyclerView.Adapter<ChatTileViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatTileViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ChatTileViewHolder(ItemChatTileBinding.inflate(layoutInflater, parent, false),
            listener)
    }

    override fun onBindViewHolder(holder: ChatTileViewHolder, position: Int) {
        holder.bind(chatList[position])
    }

    override fun getItemCount(): Int = chatList.size
}