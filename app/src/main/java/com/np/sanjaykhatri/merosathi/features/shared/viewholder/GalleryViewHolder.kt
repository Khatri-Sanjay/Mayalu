package com.np.sanjaykhatri.merosathi.features.shared.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.np.sanjaykhatri.merosathi.R
import com.np.sanjaykhatri.merosathi.databinding.ItemGalleryPhotoBinding
import com.np.sanjaykhatri.merosathi.features.shared.model.Photo

class GalleryViewHolder(
    val binding: ItemGalleryPhotoBinding,
) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(photo: Photo) {
        Glide.with(binding.imvPhoto.context)
            .load(photo.contentUri)
            .placeholder(R.drawable.mayalu_app_icon)
            .error(R.drawable.mayalu_app_icon)
            .into(binding.imvPhoto)
    }
}