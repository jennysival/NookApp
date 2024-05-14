package com.jennysival.nookapp.ui.gyroids.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jennysival.nookapp.databinding.GyroidItemBinding
import com.jennysival.nookapp.ui.gyroids.model.UiGyroidsModel
import com.jennysival.nookapp.ui.gyroids.model.UiVariation
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class GyroidsVariationAdapter(
    private var gyroid: UiGyroidsModel,
    private var variationList: MutableList<UiVariation>,
    private val onCheckClick: (gyroid: UiGyroidsModel, position: Int) -> Unit
) : RecyclerView.Adapter<GyroidsVariationAdapter.ViewHolder>() {

    class ViewHolder(val binding: GyroidItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun showGyroidVariations(variation: UiVariation) {
            if (variation.gotVariation) {
                binding.ivCheck.alpha = 1F
            } else {
                binding.ivCheck.alpha = 0.3F
            }

            if (variation.imageUrl.isNotEmpty()) {
                binding.ivCheck.visibility = View.VISIBLE
                binding.ivGyroid.visibility = View.VISIBLE
                binding.pbLoad.visibility = View.VISIBLE
                Picasso.get().load(variation.imageUrl).fit()
                    .into(binding.ivGyroid, object : Callback {
                        override fun onSuccess() {
                            binding.pbLoad.visibility = View.GONE
                        }

                        override fun onError(e: Exception?) {
                            binding.ivCheck.visibility = View.GONE
                            binding.ivGyroid.visibility = View.GONE
                            binding.pbLoad.visibility = View.GONE
                        }

                    })
                binding.ivGyroid.contentDescription = variation.variation
            } else {
                binding.ivCheck.visibility = View.GONE
                binding.ivGyroid.visibility = View.GONE
                binding.pbLoad.visibility = View.GONE
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            GyroidItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = variationList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val gyroidVariation = variationList[position]
        holder.showGyroidVariations(gyroidVariation)

        holder.binding.ivCheck.setOnClickListener {
            gyroidVariation.gotVariation = !gyroidVariation.gotVariation
            onCheckClick(gyroid, position)
            notifyItemChanged(position)
        }
    }
}