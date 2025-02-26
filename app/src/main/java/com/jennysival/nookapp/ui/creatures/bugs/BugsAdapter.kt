package com.jennysival.nookapp.ui.creatures.bugs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jennysival.nookapp.databinding.CreatureItemBinding
import com.squareup.picasso.Picasso

class BugsAdapter(
    private var bugsList: MutableList<BugsUiModel>,
    private val onBugClick: (uiBug: BugsUiModel) -> Unit
) : RecyclerView.Adapter<BugsAdapter.ViewHolder>() {

    class ViewHolder(val binding: CreatureItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun showBug(uiBug: BugsUiModel) {
            Picasso.get().load(uiBug.imageUrl).noFade().fit().into(binding.ivCreature)
            binding.ivCreature.contentDescription = uiBug.name
            if (uiBug.catchBug) {
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

    override fun getItemCount(): Int = bugsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val uiBbug = bugsList[position]
        holder.showBug(uiBbug)

        holder.binding.itemCreat.setOnClickListener {
            uiBbug.catchBug = !uiBbug.catchBug
            onBugClick(uiBbug)
            notifyItemChanged(position)
        }
    }

    fun addBugsList(addedBugsList: MutableList<BugsUiModel>) {
        if (bugsList.isEmpty()) {
            bugsList = addedBugsList
        }
        notifyDataSetChanged()
    }
}