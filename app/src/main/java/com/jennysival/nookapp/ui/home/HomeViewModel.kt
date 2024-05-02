package com.jennysival.nookapp.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.jennysival.nookapp.repository.FeaturesRepository

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val featuresRepository = FeaturesRepository()

    fun getHomeFeatures() = featuresRepository.getFeaturesList()

}