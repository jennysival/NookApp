package com.jennysival.nookapp.ui.creatures.fishes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jennysival.nookapp.databinding.CreatureItemBinding
import com.squareup.picasso.Picasso

class FishesAdapter(
    private var fishesList: MutableList<FishesUiModel>,
    private val onFishClick: (uiFish: FishesUiModel) -> Unit
) : RecyclerView.Adapter<FishesAdapter.ViewHolder>() {

    class ViewHolder(val binding: CreatureItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun showFish(uiFish: FishesUiModel) {
            Picasso.get().load(uiFish.imageUrl).noFade().fit().into(binding.ivCreature)
            binding.ivCreature.contentDescription = uiFish.name
            if (uiFish.catchFish) {
                binding.ivCreature.alpha = 1F
            } else {
                binding.ivCreature.alpha = 0.3F
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CreatureItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = fishesList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val uiFish = fishesList[position]
        holder.showFish(uiFish)

        holder.binding.itemCreat.setOnClickListener {
            uiFish.catchFish = !uiFish.catchFish
            onFishClick(uiFish)
            notifyItemChanged(position)
        }
    }

    fun addFishesList(addedFishesList: MutableList<FishesUiModel>) {
        if (fishesList.isEmpty()) {
            fishesList = addedFishesList
        }
        notifyDataSetChanged()
    }
}