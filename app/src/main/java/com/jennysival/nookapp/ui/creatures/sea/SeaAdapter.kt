package com.jennysival.nookapp.ui.creatures.sea

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jennysival.nookapp.databinding.CreatureItemBinding
import com.squareup.picasso.Picasso

class SeaAdapter(
    private var seaList: MutableList<SeaUiModel>,
    private val onSeaClick: (uiSea: SeaUiModel) -> Unit
) : RecyclerView.Adapter<SeaAdapter.ViewHolder>() {

    class ViewHolder(val binding: CreatureItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun showSea(uiSea: SeaUiModel) {
            Picasso.get().load(uiSea.imageUrl).noFade().fit().into(binding.ivCreature)
            binding.ivCreature.contentDescription = uiSea.name
            if (uiSea.catchSea) {
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

    override fun getItemCount(): Int = seaList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val uiSea = seaList[position]
        holder.showSea(uiSea)

        holder.binding.itemCreat.setOnClickListener {
            uiSea.catchSea = !uiSea.catchSea
            onSeaClick(uiSea)
            notifyItemChanged(position)
        }
    }

    fun addSeaList(addedSeaList: MutableList<SeaUiModel>) {
        if (seaList.isEmpty()) {
            seaList = addedSeaList
        }
        notifyDataSetChanged()
    }
}