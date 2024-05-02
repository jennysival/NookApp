package com.jennysival.nookapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jennysival.nookapp.data.local.FeaturesModel
import com.jennysival.nookapp.databinding.FeatureItemBinding

class FeaturesAdapter(
    private var feauresList: List<FeaturesModel>,
    private val onFeatureClick: (feature: FeaturesModel) -> Unit
) : RecyclerView.Adapter<FeaturesAdapter.ViewHolder>() {

    class ViewHolder(val binding: FeatureItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun showFeature(feature: FeaturesModel) {
            binding.ivIconFeat.setImageResource(feature.icon)
            binding.ivIconFeat.contentDescription = feature.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FeatureItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = feauresList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val feature = feauresList[position]
        holder.showFeature(feature)

        holder.binding.cvFeatItem.setOnClickListener {
            onFeatureClick(feature)
        }
    }
}