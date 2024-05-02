package com.jennysival.nookapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import com.jennysival.nookapp.R
import com.jennysival.nookapp.data.local.FeaturesModel
import com.jennysival.nookapp.databinding.FragmentHomeBinding
import com.jennysival.nookapp.utils.NOOKAPP_FEAT_KEY

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val homeViewModel: HomeViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }

    private val featuresAdapter: FeaturesAdapter by lazy {
        FeaturesAdapter(homeViewModel.getHomeFeatures(), this::onFeatureClicked)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showFeaturesList()
    }

    private fun showFeaturesList() {
        binding.rvFeatures.adapter = featuresAdapter
        binding.rvFeatures.layoutManager = GridLayoutManager(this.activity, 3)
    }

    private fun onFeatureClicked(feature: FeaturesModel) {
        navigateToFeature(feature)
    }

    private fun navigateToFeature(feature: FeaturesModel) {
        val featureBundle = bundleOf(NOOKAPP_FEAT_KEY to feature)
        NavHostFragment.findNavController(this).navigate(R.id.action_homeFragment_to_creaturesFragment, featureBundle)
    }

}