package com.jennysival.nookapp.ui.gyroids.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jennysival.nookapp.R
import com.jennysival.nookapp.databinding.GyroidlistItemBinding
import com.jennysival.nookapp.ui.gyroids.model.UiGyroidsModel

class GyroidsListAdapter(
    private var gyroidsList: MutableList<UiGyroidsModel>,
    private val onGyroidClick: (uiGyroid: UiGyroidsModel) -> Unit
) : RecyclerView.Adapter<GyroidsListAdapter.ViewHolder>() {
    var selectedItemIndex = -1

    class ViewHolder(val binding: GyroidlistItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun showGyroidName(uiGyroid: UiGyroidsModel) {
            binding.gyroidNameText.text = uiGyroid.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            GyroidlistItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = gyroidsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val uiGyroidName = gyroidsList[position]
        holder.showGyroidName(uiGyroidName)

        if (uiGyroidName.isSelected) {
            holder.binding.itemGyroidlist.setBackgroundResource(R.color.green)
            holder.binding.gyroidNameText.setTextColor(Color.parseColor("#F7F3E7"))
        } else {
            holder.binding.itemGyroidlist.setBackgroundResource(R.color.super_light_green)
            holder.binding.gyroidNameText.setTextColor(Color.parseColor("#877358"))
        }

        holder.binding.itemGyroidlist.setOnClickListener {
            uiGyroidName.isSelected = true
            if (selectedItemIndex != -1)
                gyroidsList[selectedItemIndex].isSelected = false
            selectedItemIndex = position
            notifyDataSetChanged()
            onGyroidClick(uiGyroidName)
        }
    }

    fun addGyroidList(addedGyroidsList: MutableList<UiGyroidsModel>) {
        if (gyroidsList.isEmpty()) {
            gyroidsList = addedGyroidsList
        }
        notifyDataSetChanged()
    }
}