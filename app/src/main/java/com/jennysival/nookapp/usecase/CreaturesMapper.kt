package com.jennysival.nookapp.usecase

import com.jennysival.nookapp.data.remote.bugs.BugsResponseItem
import com.jennysival.nookapp.ui.creatures.BugsUiModel

class CreaturesMapper {
    private fun mapApiBugToUiBug(apiBug: BugsResponseItem): BugsUiModel {
        return BugsUiModel(
            catchphrases = apiBug.catchphrases,
            imageUrl = apiBug.imageUrl,
            location = apiBug.location,
            name = apiBug.name,
            north = apiBug.north,
            number = apiBug.number,
            rarity = apiBug.rarity,
            renderUrl = apiBug.renderUrl,
            sellFlick = apiBug.sellFlick,
            sellNook = apiBug.sellNook,
            south = apiBug.south,
            tankLength = apiBug.tankLength,
            tankWidth = apiBug.tankWidth,
            totalCatch = apiBug.totalCatch,
            url = apiBug.url
        )
    }

    fun getBugsList(apiBugsList: List<BugsResponseItem>): List<BugsUiModel> {
        val uiBugsList = mutableListOf<BugsUiModel>()
        apiBugsList.forEach { apiBug ->
            uiBugsList.add(mapApiBugToUiBug(apiBug))
        }
        return uiBugsList
    }
}