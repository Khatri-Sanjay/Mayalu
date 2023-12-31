package com.np.sanjaykhatri.merosathi.features.shared.viewholder

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.np.sanjaykhatri.merosathi.R
import com.np.sanjaykhatri.merosathi.databinding.ItemPostBinding
import com.np.sanjaykhatri.merosathi.features.shared.model.Post

class PostViewHolder(
    val binding: ItemPostBinding,
    private val currentUserId: String,
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(post: Post) {
        binding.txvUsername.text = post.postBy
        binding.txvPostDate.text = post.postDate
        binding.txvPostContent.text = post.postContent

        Glide.with(binding.imvProfilePicture.context).load(post.postUserPhotoUrl)
            .placeholder(R.drawable.mayalu_app_icon)
            .error(R.drawable.mayalu_app_icon)
            .into(binding.imvProfilePicture)

        if (post.postUserId != currentUserId) {
            binding.imvPostDelete.isVisible = false
            binding.imvPostEdit.isVisible = false
        }
    }
}