package com.jennysival.nookapp.usecase

import com.jennysival.nookapp.data.remote.bugs.BugsResponseItem
import com.jennysival.nookapp.data.remote.fishes.FishesResponseItem
import com.jennysival.nookapp.data.remote.sea.SeaResponseItem
import com.jennysival.nookapp.ui.creatures.bugs.BugsUiModel
import com.jennysival.nookapp.ui.creatures.fishes.FishesUiModel
import com.jennysival.nookapp.ui.creatures.sea.SeaUiModel

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

    fun getBugsList(apiBugsList: List<BugsResponseItem>): List<BugsUiModel> {
        val uiBugsList = mutableListOf<BugsUiModel>()
        apiBugsList.forEach { apiBug ->
            uiBugsList.add(mapApiBugToUiBug(apiBug))
        }
        return uiBugsList
    }

    private fun mapApiFishToUiFish(apiFish: FishesResponseItem): FishesUiModel {
        return FishesUiModel(
            imageUrl = apiFish.imageUrl,
            location = apiFish.location,
            name = apiFish.name,
            number = apiFish.number,
            rarity = apiFish.rarity,
            renderUrl = apiFish.renderUrl,
            sellCj = apiFish.sellCj,
            sellNook = apiFish.sellNook,
            shadowSize = apiFish.shadowSize,
            tankLength = apiFish.tankLength,
            tankWidth = apiFish.tankWidth,
            totalCatch = apiFish.totalCatch,
            url = apiFish.url,
            catchFish = apiFish.catchFish
        )
    }

   fun getCatchFish(uiFish: FishesUiModel): FishesResponseItem {
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

    fun getFishesList(apiFishesList: List<FishesResponseItem>): List<FishesUiModel> {
        val uiFishesList = mutableListOf<FishesUiModel>()
        apiFishesList.forEach { apiFish ->
            uiFishesList.add(mapApiFishToUiFish(apiFish))
        }
        return uiFishesList
    }

    private fun mapApiSeaToUiSea(apiSea: SeaResponseItem): SeaUiModel {
        return SeaUiModel(
            imageUrl = apiSea.imageUrl,
            name = apiSea.name,
            number = apiSea.number,
            rarity = apiSea.rarity,
            renderUrl = apiSea.renderUrl,
            sellNook = apiSea.sellNook,
            shadowMovement = apiSea.shadowMovement,
            shadowSize = apiSea.shadowSize,
            tankLength = apiSea.tankLength,
            tankWidth = apiSea.tankWidth,
            totalCatch = apiSea.totalCatch,
            url = apiSea.url,
            catchSea = apiSea.catchSea
        )
    }

    fun getCatchSea(uiSea: SeaUiModel): SeaResponseItem {
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

    fun getSeaList(apiSeaList: List<SeaResponseItem>): List<SeaUiModel> {
        val uiSeaList = mutableListOf<SeaUiModel>()
        apiSeaList.forEach { apiSea ->
            uiSeaList.add(mapApiSeaToUiSea(apiSea))
        }
        return uiSeaList
    }
}