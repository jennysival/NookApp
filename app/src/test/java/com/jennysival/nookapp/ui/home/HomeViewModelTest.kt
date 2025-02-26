package com.jennysival.nookapp.ui.home

import com.jennysival.nookapp.data.local.FeaturesModel
import com.jennysival.nookapp.repository.FeaturesRepository
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert
import org.junit.Test

class HomeViewModelTest {

    @Test
    fun `getHomeFeatures should return features list from repository`() {
        val mockFeaturesRepository = mockk<FeaturesRepository>()
        val viewModel = HomeViewModel(mockFeaturesRepository)

        val expectedFeaturesList = listOf(
            FeaturesModel(name = "mock", icon = 1),
        )

        every { mockFeaturesRepository.getFeaturesList() } returns expectedFeaturesList
        val actualFeaturesList = viewModel.getHomeFeatures()

        Assert.assertEquals(expectedFeaturesList, actualFeaturesList)
    }

}