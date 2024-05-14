package com.jennysival.nookapp.ui.gyroids

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
import androidx.recyclerview.widget.LinearLayoutManager
import com.jennysival.nookapp.R
import com.jennysival.nookapp.databinding.FragmentGyroidsBinding
import com.jennysival.nookapp.ui.gyroids.adapter.GyroidsListAdapter
import com.jennysival.nookapp.ui.gyroids.adapter.GyroidsVariationAdapter
import com.jennysival.nookapp.ui.gyroids.model.UiGyroidsModel
import com.jennysival.nookapp.ui.gyroids.model.UiVariation
import com.jennysival.nookapp.utils.ViewState


class GyroidsFragment : Fragment() {

    private lateinit var binding: FragmentGyroidsBinding

    private lateinit var gyroidsViewModel: GyroidsViewModel

    private val gyroidsListAdapter: GyroidsListAdapter by lazy {
        GyroidsListAdapter(mutableListOf(), this::onGyroidClicked)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGyroidsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpInitialDialogue()
        initViewModel()
        initObserver()
        gyroidsViewModel.getGyroidsFromDatabase()
        showGyroidsList()
        onBackClicked()
    }

    private fun initViewModel() {
        gyroidsViewModel =
            ViewModelProvider(
                this,
                GyroidsViewModelFactory(requireActivity())
            )[GyroidsViewModel::class.java]
    }

    private fun initObserver() {
        gyroidsViewModel.loadState.observe(this.viewLifecycleOwner) {
            when (it) {
                is ViewState.Loading -> {
                    binding.pbLoad.isVisible = it.loading == true
                }

                else -> {}
            }
        }

        gyroidsViewModel.gyroidsListState.observe(this.viewLifecycleOwner) {
            when (it) {
                is ViewState.Success -> {
                    gyroidsListAdapter.addGyroidList(it.data as MutableList<UiGyroidsModel>)
                }

                is ViewState.Error -> Toast.makeText(
                    this.activity,
                    "${it.throwable.message}",
                    Toast.LENGTH_LONG
                ).show()

                else -> {}
            }
        }
    }

    private fun showGyroidsList() {
        binding.rvGyroidsList.adapter = gyroidsListAdapter
        binding.rvGyroidsList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun setUpVariationsAdapter(clickedGyroid: UiGyroidsModel) {
        val variationsAdapter = GyroidsVariationAdapter(
            clickedGyroid,
            clickedGyroid.variations as MutableList<UiVariation>,
            this::onCheckClicked
        )
        binding.rvGyroidsImages.adapter = variationsAdapter
        binding.rvGyroidsImages.layoutManager =
            GridLayoutManager(this.activity, 1, GridLayoutManager.HORIZONTAL, false)
        binding.rvGyroidsImages.layoutManager?.scrollToPosition(0)
    }

    private fun onGyroidClicked(clickedGyroid: UiGyroidsModel) {
        setRandomDialogue()
        setUpVariationsAdapter(clickedGyroid)
    }

    private fun onBackClicked() {
        binding.ivBackbutton.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_gyroidsFragment_to_homeFragment)
        }
    }

    private fun onCheckClicked(gyroid: UiGyroidsModel, position: Int) {
        val gotText = "Um ${gyroid.name}... ${BrewsterDialogues.GOOD_CONDITIONS}"
        if (gyroid.variations[position].gotVariation) {
            gyroidsViewModel.updateGotGyroid(gyroid)
            binding.tvDialogue.text = gotText
        } else {
            gyroidsViewModel.updateGotGyroid(gyroid)
            binding.tvDialogue.text = BrewsterDialogues.GIVE_BACK
        }
    }

    private fun setUpInitialDialogue() {
        binding.tvDialogue.text = BrewsterDialogues.INITIAL
    }

    private fun setRandomDialogue() {
        binding.tvDialogue.text = gyroidsViewModel.getRandomDialogue()
    }
}