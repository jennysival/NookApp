package com.jennysival.nookapp.usecase

import com.jennysival.nookapp.data.remote.bugs.BugsResponseItem
import com.jennysival.nookapp.data.remote.fishes.FishesResponseItem
import com.jennysival.nookapp.data.remote.sea.SeaResponseItem
import com.jennysival.nookapp.ui.creatures.bugs.BugsUiModel
import com.jennysival.nookapp.ui.creatures.fishes.FishesUiModel
import com.jennysival.nookapp.ui.creatures.sea.SeaUiModel

class CreaturesMapper {

    fun mapSingleBugUiToApi(uiBug: BugsUiModel): BugsResponseItem {
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

    fun mapBugsApiToUi(apiBugsList: List<BugsResponseItem>): List<BugsUiModel> =
        apiBugsList.map {
            BugsUiModel(
                imageUrl = it.imageUrl,
                location = it.location,
                name = it.name,
                number = it.number,
                rarity = it.rarity,
                renderUrl = it.renderUrl,
                sellFlick = it.sellFlick,
                sellNook = it.sellNook,
                tankLength = it.tankLength,
                tankWidth = it.tankWidth,
                totalCatch = it.totalCatch,
                url = it.url,
                catchBug = it.catchBug
            )
        }

   fun mapSingleFishUiToApi(uiFish: FishesUiModel): FishesResponseItem {
        return FishesResponseItem(
            imageUrl = uiFish.imageUrl,
            location = uiFish.location,
            name = uiFish.name,
            number = uiFish.number,
            rarity = uiFish.rarity,
            renderUrl = uiFish.renderUrl,
            sellCj = uiFish.sellCj,
            sellNook = uiFish.sellNook,
            shadowSize = uiFish.shadowSize,
            tankLength = uiFish.tankLength,
            tankWidth = uiFish.tankWidth,
            totalCatch = uiFish.totalCatch,
            url = uiFish.url,
            catchFish = uiFish.catchFish
        )
    }

    fun mapFishesApiToUi(apiFishesList: List<FishesResponseItem>): List<FishesUiModel> =
        apiFishesList.map {
            FishesUiModel(
                imageUrl = it.imageUrl,
                location = it.location,
                name = it.name,
                number = it.number,
                rarity = it.rarity,
                renderUrl = it.renderUrl,
                sellCj = it.sellCj,
                sellNook = it.sellNook,
                shadowSize = it.shadowSize,
                tankLength = it.tankLength,
                tankWidth = it.tankWidth,
                totalCatch = it.totalCatch,
                url = it.url,
                catchFish = it.catchFish
            )
        }

    fun mapSingleSeaUiToApi(uiSea: SeaUiModel): SeaResponseItem {
        return SeaResponseItem(
            imageUrl = uiSea.imageUrl,
            name = uiSea.name,
            number = uiSea.number,
            rarity = uiSea.rarity,
            renderUrl = uiSea.renderUrl,
            sellNook = uiSea.sellNook,
            shadowMovement = uiSea.shadowMovement,
            shadowSize = uiSea.shadowSize,
            tankLength = uiSea.tankLength,
            tankWidth = uiSea.tankWidth,
            totalCatch = uiSea.totalCatch,
            url = uiSea.url,
            catchSea = uiSea.catchSea
        )
    }

    fun mapSeaApiToUi(apiSeaList: List<SeaResponseItem>): List<SeaUiModel> =
        apiSeaList.map {
            SeaUiModel(
                imageUrl = it.imageUrl,
                name = it.name,
                number = it.number,
                rarity = it.rarity,
                renderUrl = it.renderUrl,
                sellNook = it.sellNook,
                shadowMovement = it.shadowMovement,
                shadowSize = it.shadowSize,
                tankLength = it.tankLength,
                tankWidth = it.tankWidth,
                totalCatch = it.totalCatch,
                url = it.url,
                catchSea = it.catchSea
            )
        }
}