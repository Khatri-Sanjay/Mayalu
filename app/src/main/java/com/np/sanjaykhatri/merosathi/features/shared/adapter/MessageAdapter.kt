package com.np.sanjaykhatri.merosathi.features.shared.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.np.sanjaykhatri.merosathi.databinding.ItemMessageOthersBinding
import com.np.sanjaykhatri.merosathi.databinding.ItemMessageSelfBinding
import com.np.sanjaykhatri.merosathi.features.shared.model.ChatData
import com.np.sanjaykhatri.merosathi.features.shared.viewholder.BaseViewHolder
import com.np.sanjaykhatri.merosathi.features.shared.viewholder.MessageOthersViewHolder
import com.np.sanjaykhatri.merosathi.features.shared.viewholder.MessageSelfViewHolder

const val TYPE_SELF = 100
const val TYPE_OTHERS = 101

class MessageAdapter(private val messageList: MutableList<ChatData>, private val userId: String) :
    RecyclerView.Adapter<BaseViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            TYPE_SELF -> MessageSelfViewHolder(ItemMessageSelfBinding.inflate(layoutInflater,
                parent,
                false))
            else -> MessageOthersViewHolder(ItemMessageOthersBinding.inflate(layoutInflater,
                parent,
                false))
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (messageList[position].sentBy) {
            userId -> (holder as MessageSelfViewHolder).bind(messageList[position])
            else -> (holder as MessageOthersViewHolder).bind(messageList[position])
        }
    }

    override fun getItemCount(): Int = messageList.size

    override fun getItemViewType(position: Int): Int {
        return when (messageList[position].sentBy) {
            userId -> TYPE_SELF
            else -> TYPE_OTHERS
        }
    }
}