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
import com.jennysival.nookapp.utils.NOOKAPP_AGENDA
import com.jennysival.nookapp.utils.NOOKAPP_AMIGOS
import com.jennysival.nookapp.utils.NOOKAPP_CATALOGO
import com.jennysival.nookapp.utils.NOOKAPP_CONQUISTAS
import com.jennysival.nookapp.utils.NOOKAPP_CRIATURAS
import com.jennysival.nookapp.utils.NOOKAPP_FEAT_KEY
import com.jennysival.nookapp.utils.NOOKAPP_FINANCAS
import com.jennysival.nookapp.utils.NOOKAPP_FLORES
import com.jennysival.nookapp.utils.NOOKAPP_FOSSEIS
import com.jennysival.nookapp.utils.NOOKAPP_GYROIDS
import com.jennysival.nookapp.utils.NOOKAPP_MINHA_ILHA
import com.jennysival.nookapp.utils.NOOKAPP_MISSOES
import com.jennysival.nookapp.utils.NOOKAPP_MUSICAS
import com.jennysival.nookapp.utils.NOOKAPP_RECEITAS
import com.jennysival.nookapp.utils.NOOKAPP_SOBRE
import com.jennysival.nookapp.utils.NOOKAPP_VISITANTES

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private lateinit var homeViewModel: HomeViewModel

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
        initViewModel()
        showFeaturesList()
    }

    private fun initViewModel() {
        homeViewModel = ViewModelProvider(this, HomeViewModelFactory())[HomeViewModel::class.java]
    }

    private fun showFeaturesList() {
        binding.rvFeatures.adapter = featuresAdapter
        binding.rvFeatures.layoutManager = GridLayoutManager(this.activity, 3)
    }

    private fun onFeatureClicked(feature: FeaturesModel) {
        when (feature.name) {
            NOOKAPP_AGENDA -> navigateToFeatures(
                feature = feature,
                navId = R.id.action_homeFragment_to_creaturesFragment
            )

            NOOKAPP_AMIGOS -> navigateToFeatures(
                feature = feature,
                navId = R.id.action_homeFragment_to_creaturesFragment
            )

            NOOKAPP_CATALOGO -> navigateToFeatures(
                feature = feature,
                navId = R.id.action_homeFragment_to_creaturesFragment
            )

            NOOKAPP_CRIATURAS -> navigateToFeatures(
                feature = feature,
                navId = R.id.action_homeFragment_to_creaturesFragment
            )

            NOOKAPP_CONQUISTAS -> navigateToFeatures(
                feature = feature,
                navId = R.id.action_homeFragment_to_creaturesFragment
            )

            NOOKAPP_FINANCAS -> navigateToFeatures(
                feature = feature,
                navId = R.id.action_homeFragment_to_creaturesFragment
            )

            NOOKAPP_FLORES -> navigateToFeatures(
                feature = feature,
                navId = R.id.action_homeFragment_to_creaturesFragment
            )

            NOOKAPP_FOSSEIS -> navigateToFeatures(
                feature = feature,
                navId = R.id.action_homeFragment_to_creaturesFragment
            )

            NOOKAPP_GYROIDS -> navigateToFeatures(
                feature = feature,
                navId = R.id.action_homeFragment_to_gyroidsFragment
            )

            NOOKAPP_MINHA_ILHA -> navigateToFeatures(
                feature = feature,
                navId = R.id.action_homeFragment_to_creaturesFragment
            )

            NOOKAPP_MISSOES -> navigateToFeatures(
                feature = feature,
                navId = R.id.action_homeFragment_to_creaturesFragment
            )

            NOOKAPP_MUSICAS -> navigateToFeatures(
                feature = feature,
                navId = R.id.action_homeFragment_to_creaturesFragment
            )

            NOOKAPP_RECEITAS -> navigateToFeatures(
                feature = feature,
                navId = R.id.action_homeFragment_to_creaturesFragment
            )

            NOOKAPP_SOBRE -> navigateToFeatures(
                feature = feature,
                navId = R.id.action_homeFragment_to_creaturesFragment
            )

            NOOKAPP_VISITANTES -> navigateToFeatures(
                feature = feature,
                navId = R.id.action_homeFragment_to_creaturesFragment
            )
        }
    }

    private fun navigateToFeatures(feature: FeaturesModel, navId: Int) {
        val featureBundle = bundleOf(NOOKAPP_FEAT_KEY to feature)
        NavHostFragment.findNavController(this).navigate(navId, featureBundle)
    }

}