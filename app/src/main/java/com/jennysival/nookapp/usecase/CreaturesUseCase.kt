package com.jennysival.nookapp.usecase

import com.jennysival.nookapp.repository.CreaturesRepository
import com.jennysival.nookapp.ui.creatures.BugsUiModel
import com.jennysival.nookapp.utils.ViewState

class CreaturesUseCase(
    private val creaturesRepository: CreaturesRepository = CreaturesRepository(),
    private val creaturesMapper: CreaturesMapper = CreaturesMapper()
    ) {

    suspend fun getBugs() : ViewState<List<BugsUiModel>> {
        return try {
            val apiBugsList = creaturesRepository.getBugs()
            val uiBugsList = creaturesMapper.getBugsList(apiBugsList).sortedBy {
                it.number.inc()
            }
            ViewState.Success(uiBugsList)
        } catch (e: Exception) {
            ViewState.Error(Exception(e.message))
        }
    }

}