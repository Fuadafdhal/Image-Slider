package com.afdhal_fa.imagesliderlibarary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.afdhal_fa.imagesliderlibarary.databinding.ItemImageSliderBinding

/**
 * Created by Muh Fuad Afdhal on 30/06/2021
 * Email: fuad.afdal.fa@gmail.com
 */

class ImageSlideAdapter : RecyclerView.Adapter<ImageSlideAdapter.VHolder>() {
    private var items: MutableList<String> = mutableListOf()

    var onItemClick: ((String) -> Unit)? = null

    fun setItem(items: List<String>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }


    inner class VHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemImageSliderBinding.bind(itemView)

        fun onBind(image: String) {
            binding.imageSlide.load(image)

            binding.root.setOnClickListener {
                onItemClick?.invoke(image)
            }
        }
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: VHolder, position: Int) {
        holder.onBind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_image_slider, parent, false)
    )
}