package com.jennysival.nookapp.ui.creatures.sea

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
import com.jennysival.nookapp.databinding.FragmentSeaBinding
import com.jennysival.nookapp.ui.creatures.CreaturesViewModel
import com.jennysival.nookapp.ui.creatures.CreaturesViewModelFactory
import com.jennysival.nookapp.utils.ViewState

class SeaFragment : Fragment() {

    private lateinit var binding: FragmentSeaBinding

    private lateinit var creaturesViewModel: CreaturesViewModel

    private val seaAdapter: SeaAdapter by lazy {
        SeaAdapter(mutableListOf(), this::onSeaClicked)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSeaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initObserver()
        creaturesViewModel.getSeaFromDatabase()
        showSeaList()
        onBackClicked()
        onBugButtonClick()
        onFishButtonClick()
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

        creaturesViewModel.seaListState.observe(this.viewLifecycleOwner) {
            when (it) {
                is ViewState.Success -> {
                    seaAdapter.addSeaList(it.data as MutableList<SeaUiModel>)
                }

                is ViewState.Error -> Toast.makeText(
                    this.activity, "${it.throwable.message}",
                    Toast.LENGTH_LONG
                ).show()

                else -> {}
            }
        }
    }

    private fun showSeaList() {
        binding.cvSea.alpha = 0.5F
        binding.rvSea.adapter = seaAdapter
        binding.rvSea.layoutManager =
            GridLayoutManager(this.activity, 6, GridLayoutManager.HORIZONTAL, false)
    }

    private fun onSeaClicked(clickedSea: SeaUiModel) {
        if (clickedSea.catchSea) {
            creaturesViewModel.updateCatchSea(clickedSea)
            Toast.makeText(this.activity, "YAY! Você pegou ${clickedSea.name}!", Toast.LENGTH_LONG)
                .show()
        } else {
            creaturesViewModel.updateCatchSea(clickedSea)
            Toast.makeText(
                this.activity,
                "ops, ${clickedSea.name} fugiu!",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun onBugButtonClick() {
        binding.cvBugs.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_seaFragment_to_creaturesFragment)
        }
    }

    private fun onFishButtonClick() {
        binding.cvFishes.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_seaFragment_to_fishesFragment)
        }
    }

    private fun onBackClicked() {
        binding.ivBackbutton.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_seaFragment_to_homeFragment)
        }
    }
}