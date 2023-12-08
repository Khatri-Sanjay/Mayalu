package com.np.sanjaykhatri.merosathi.features.shared.viewholder

import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.np.sanjaykhatri.merosathi.R
import com.np.sanjaykhatri.merosathi.databinding.ItemMessageSelfBinding
import com.np.sanjaykhatri.merosathi.features.shared.model.ChatData

class MessageSelfViewHolder(private val binding: ItemMessageSelfBinding) :
    BaseViewHolder(binding.root) {
    fun bind(chatData: ChatData) {
        if (chatData.pictureUrl?.isNotEmpty() == true) {
            binding.imvImage.isVisible = true
            Glide.with(binding.imvImage)
                .load(chatData.pictureUrl)
                .error(R.drawable.mayalu_app_icon)
                .placeholder(R.drawable.mayalu_app_icon)
                .into(binding.imvImage)
        }
        if(chatData.message?.isEmpty() == true) {
            binding.txvMessage.isVisible = false
        }
        binding.txvMessage.text = chatData.message
        binding.txvTimeStamp.text = chatData.timeStamp
    }
}