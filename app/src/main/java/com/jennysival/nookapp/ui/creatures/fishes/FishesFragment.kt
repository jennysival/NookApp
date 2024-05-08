package com.jennysival.nookapp.ui.creatures.fishes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import com.jennysival.nookapp.R
import com.jennysival.nookapp.databinding.FragmentFishesBinding
import com.jennysival.nookapp.ui.creatures.CreaturesViewModel
import com.jennysival.nookapp.ui.creatures.CreaturesViewModelFactory
import com.jennysival.nookapp.utils.ViewState

class FishesFragment : Fragment() {

    private lateinit var binding: FragmentFishesBinding

    private lateinit var creaturesViewModel: CreaturesViewModel

    private val fishesAdapter: FishesAdapter by lazy {
        FishesAdapter(mutableListOf(), this::onFishClicked)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFishesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initObserver()
        creaturesViewModel.getFishesFromDatabase()
        showCreaturesList()
        onBackClicked()
        onBugButtonClick()
        onSeaButtonClick()
    }

    private fun initViewModel() {
        creaturesViewModel =
            ViewModelProvider(
                this,
                CreaturesViewModelFactory(requireActivity())
            )[CreaturesViewModel::class.java]
    }

    private fun initObserver() {
        creaturesViewModel.loadState.observe(this.viewLifecycleOwner) {
            when (it) {
                is ViewState.Loading -> {
                    binding.pbLoad.isVisible = it.loading == true
                }

                else -> {}
            }
        }

        creaturesViewModel.fishesListState.observe(this.viewLifecycleOwner) {
            when (it) {
                is ViewState.Success -> {
                    fishesAdapter.addFishesList(it.data as MutableList<FishesUiModel>)
                }

                is ViewState.Error -> Toast.makeText(
                    this.activity, "${it.throwable.message}",
                    Toast.LENGTH_LONG
                ).show()

                else -> {}
            }
        }
    }

    private fun showCreaturesList() {
        binding.cvFishes.alpha = 0.5F
        binding.rvFishes.adapter = fishesAdapter
        binding.rvFishes.layoutManager =
            GridLayoutManager(this.activity, 6, GridLayoutManager.HORIZONTAL, false)
    }

    private fun onFishClicked(clickedFish: FishesUiModel) {
        if (clickedFish.catchFish) {
            creaturesViewModel.updateCatchFish(clickedFish)
            Toast.makeText(this.activity, "YAY! Você pegou ${clickedFish.name}!", Toast.LENGTH_LONG)
                .show()
        } else {
            creaturesViewModel.updateCatchFish(clickedFish)
            Toast.makeText(
                this.activity,
                "ops, ${clickedFish.name} fugiu!",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun onBugButtonClick() {
        binding.cvBugs.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_fishesFragment_to_creaturesFragment)
        }
    }

    private fun onSeaButtonClick() {
        binding.cvSea.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_fishesFragment_to_seaFragment)
        }
    }

    private fun onBackClicked() {
        binding.ivBackbutton.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_fishesFragment_to_homeFragment)
        }
    }
}