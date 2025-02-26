package com.jennysival.nookapp.ui.home

import androidx.lifecycle.ViewModel
import com.jennysival.nookapp.repository.FeaturesRepository

class HomeViewModel(private val featuresRepository: FeaturesRepository) : ViewModel() {

    fun getHomeFeatures() = featuresRepository.getFeaturesList()

}