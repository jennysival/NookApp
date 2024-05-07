package com.jennysival.nookapp.usecase

import com.jennysival.nookapp.data.remote.bugs.BugsResponseItem
import com.jennysival.nookapp.ui.creatures.BugsUiModel

class CreaturesMapper {
    private fun mapApiBugToUiBug(apiBug: BugsResponseItem): BugsUiModel {
        return BugsUiModel(
            imageUrl = apiBug.imageUrl,
            location = apiBug.location,
            name = apiBug.name,
            number = apiBug.number,
            rarity = apiBug.rarity,
            renderUrl = apiBug.renderUrl,
            sellFlick = apiBug.sellFlick,
            sellNook = apiBug.sellNook,
            tankLength = apiBug.tankLength,
            tankWidth = apiBug.tankWidth,
            totalCatch = apiBug.totalCatch,
            url = apiBug.url,
            catchBug = apiBug.catchBug
        )
    }

    fun getBugsList(apiBugsList: List<BugsResponseItem>): List<BugsUiModel> {
        val uiBugsList = mutableListOf<BugsUiModel>()
        apiBugsList.forEach { apiBug ->
            uiBugsList.add(mapApiBugToUiBug(apiBug))
        }
        return uiBugsList
    }

    fun getCatchBug(uiBug: BugsUiModel): BugsResponseItem {
        return BugsResponseItem(
            imageUrl = uiBug.imageUrl,
            location = uiBug.location,
            name = uiBug.name,
            number = uiBug.number,
            rarity = uiBug.rarity,
            renderUrl = uiBug.renderUrl,
            sellFlick = uiBug.sellFlick,
            sellNook = uiBug.sellNook,
            tankLength = uiBug.tankLength,
            tankWidth = uiBug.tankWidth,
            totalCatch = uiBug.totalCatch,
            url = uiBug.url,
            catchBug = uiBug.catchBug
        )
    }
}