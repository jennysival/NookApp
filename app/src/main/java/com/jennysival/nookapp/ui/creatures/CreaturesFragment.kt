package com.jennysival.nookapp.ui.creatures

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import com.jennysival.nookapp.R
import com.jennysival.nookapp.databinding.FragmentCreaturesBinding
import com.jennysival.nookapp.utils.ViewState

class CreaturesFragment : Fragment() {

    private lateinit var binding: FragmentCreaturesBinding

    private lateinit var creaturesViewModel: CreaturesViewModel

    private val creaturesAdapter: CreaturesAdapter by lazy {
        CreaturesAdapter(mutableListOf(), this::onBugClicked)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreaturesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initObserver()
        creaturesViewModel.getBugs()
        showCreaturesList()
        onBackClicked()
    }

    private fun initViewModel() {
        creaturesViewModel =
            ViewModelProvider(
                this,
                CreaturesViewModelFactory(requireActivity())
            )[CreaturesViewModel::class.java]
    }

    private fun initObserver() {
        creaturesViewModel.bugsListState.observe(this.viewLifecycleOwner) {
            when (it) {
                is ViewState.Success -> creaturesAdapter.addBugsList(it.data as MutableList<BugsUiModel>)
                is ViewState.Error -> Toast.makeText(
                    this.activity,
                    "${it.throwable.message}",
                    Toast.LENGTH_LONG
                ).show()

                else -> {}
            }
        }
    }

    private fun showCreaturesList() {
        binding.cvBugs.alpha = 0.5F
        binding.rvCreatures.adapter = creaturesAdapter
        binding.rvCreatures.layoutManager =
            GridLayoutManager(this.activity, 6, GridLayoutManager.HORIZONTAL, false)
    }

    private fun onBugClicked(clickedBug: BugsUiModel) {
        if (clickedBug.catchBug) {
            creaturesViewModel.updateCatchBug(clickedBug)
            Toast.makeText(this.activity, "YAY! Você pegou ${clickedBug.name}!", Toast.LENGTH_LONG)
                .show()
        } else {
            creaturesViewModel.updateCatchBug(clickedBug)
            Toast.makeText(
                this.activity,
                "ops, ${clickedBug.name} fugiu!",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun onBackClicked() {
        binding.ivBackbutton?.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_creaturesFragment_to_homeFragment)
        }
    }
}