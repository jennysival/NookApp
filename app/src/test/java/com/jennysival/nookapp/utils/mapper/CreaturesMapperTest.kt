package com.jennysival.nookapp.utils.mapper

import com.jennysival.nookapp.utils.mocks.apiBugsListMock
import com.jennysival.nookapp.utils.mocks.apiFishesListMock
import com.jennysival.nookapp.utils.mocks.apiSeaListMock
import com.jennysival.nookapp.utils.mocks.bugsUiMock
import com.jennysival.nookapp.utils.mocks.fishUiMock
import com.jennysival.nookapp.utils.mocks.seaUiMock
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class CreaturesMapperTest {

    private lateinit var mapper: CreaturesMapper

    @Before
    fun setup() {
        mapper = CreaturesMapper()
    }

    @Test
    fun `mapSingleBugUiToApi should correctly map BugsUiModel to BugsResponseItem`() {
        val apiBug = mapper.mapSingleBugUiToApi(bugsUiMock)

        Assert.assertEquals(bugsUiMock.imageUrl, apiBug.imageUrl)
        Assert.assertEquals(bugsUiMock.location, apiBug.location)
        Assert.assertEquals(bugsUiMock.name, apiBug.name)
        Assert.assertEquals(bugsUiMock.number, apiBug.number)
        Assert.assertEquals(bugsUiMock.rarity, apiBug.rarity)
        Assert.assertEquals(bugsUiMock.renderUrl, apiBug.renderUrl)
        Assert.assertEquals(bugsUiMock.sellFlick, apiBug.sellFlick)
        Assert.assertEquals(bugsUiMock.sellNook, apiBug.sellNook)
        Assert.assertEquals(bugsUiMock.tankLength, apiBug.tankLength)
        Assert.assertEquals(bugsUiMock.tankWidth, apiBug.tankWidth)
        Assert.assertEquals(bugsUiMock.totalCatch, apiBug.totalCatch)
        Assert.assertEquals(bugsUiMock.url, apiBug.url)
        Assert.assertEquals(bugsUiMock.catchBug, apiBug.catchBug)
    }

    @Test
    fun `mapBugsApiToUi should correctly map list of BugsResponseItem to list of BugsUiModel`() {
        val uiBugsList = mapper.mapBugsApiToUi(apiBugsListMock)

        Assert.assertEquals(apiBugsListMock.size, uiBugsList.size)
        for (i in apiBugsListMock.indices) {
            val apiBug = apiBugsListMock[i]
            val uiBug = uiBugsList[i]
            Assert.assertEquals(apiBug.imageUrl, uiBug.imageUrl)
            Assert.assertEquals(apiBug.location, uiBug.location)
            Assert.assertEquals(apiBug.name, uiBug.name)
            Assert.assertEquals(apiBug.number, uiBug.number)
            Assert.assertEquals(apiBug.rarity, uiBug.rarity)
            Assert.assertEquals(apiBug.renderUrl, uiBug.renderUrl)
            Assert.assertEquals(apiBug.sellFlick, uiBug.sellFlick)
            Assert.assertEquals(apiBug.sellNook, uiBug.sellNook)
            Assert.assertEquals(apiBug.tankLength, uiBug.tankLength)
            Assert.assertEquals(apiBug.tankWidth, uiBug.tankWidth)
            Assert.assertEquals(apiBug.totalCatch, uiBug.totalCatch)
            Assert.assertEquals(apiBug.url, uiBug.url)
            Assert.assertEquals(apiBug.catchBug, uiBug.catchBug)
        }
    }

    @Test
    fun `mapSingleFishUiToApi should correctly map FishesUiModel to FishesResponseItem`() {
        val apiFish = mapper.mapSingleFishUiToApi(fishUiMock)

        Assert.assertEquals(fishUiMock.imageUrl, apiFish.imageUrl)
        Assert.assertEquals(fishUiMock.location, apiFish.location)
        Assert.assertEquals(fishUiMock.name, apiFish.name)
        Assert.assertEquals(fishUiMock.number, apiFish.number)
        Assert.assertEquals(fishUiMock.rarity, apiFish.rarity)
        Assert.assertEquals(fishUiMock.renderUrl, apiFish.renderUrl)
        Assert.assertEquals(fishUiMock.sellCj, apiFish.sellCj)
        Assert.assertEquals(fishUiMock.sellNook, apiFish.sellNook)
        Assert.assertEquals(fishUiMock.shadowSize, apiFish.shadowSize)
        Assert.assertEquals(fishUiMock.tankLength, apiFish.tankLength)
        Assert.assertEquals(fishUiMock.tankWidth, apiFish.tankWidth)
        Assert.assertEquals(fishUiMock.totalCatch, apiFish.totalCatch)
        Assert.assertEquals(fishUiMock.url, apiFish.url)
        Assert.assertEquals(fishUiMock.catchFish, apiFish.catchFish)
    }

    @Test
    fun `mapFishesApiToUi should correctly map list of FishesResponseItem to list of FishesUiModel`() {
        val uiFishesList = mapper.mapFishesApiToUi(apiFishesListMock)

        Assert.assertEquals(apiFishesListMock.size, uiFishesList.size)
        for (i in apiFishesListMock.indices) {
            val apiFish = apiFishesListMock[i]
            val uiFish = uiFishesList[i]
            Assert.assertEquals(apiFish.imageUrl, uiFish.imageUrl)
            Assert.assertEquals(apiFish.location, uiFish.location)
            Assert.assertEquals(apiFish.name, uiFish.name)
            Assert.assertEquals(apiFish.number, uiFish.number)
            Assert.assertEquals(apiFish.rarity, uiFish.rarity)
            Assert.assertEquals(apiFish.renderUrl, uiFish.renderUrl)
            Assert.assertEquals(apiFish.sellCj, uiFish.sellCj)
            Assert.assertEquals(apiFish.sellNook, uiFish.sellNook)
            Assert.assertEquals(apiFish.tankLength, uiFish.tankLength)
            Assert.assertEquals(apiFish.tankWidth, uiFish.tankWidth)
            Assert.assertEquals(apiFish.totalCatch, uiFish.totalCatch)
            Assert.assertEquals(apiFish.url, uiFish.url)
            Assert.assertEquals(apiFish.catchFish, uiFish.catchFish)
        }
    }

    @Test
    fun `mapSingleSeaUiToApi should correctly map SeaUiModel to SeaResponseItem`() {
        val apiSea = mapper.mapSingleSeaUiToApi(seaUiMock)

        Assert.assertEquals(seaUiMock.imageUrl, apiSea.imageUrl)
        Assert.assertEquals(seaUiMock.name, apiSea.name)
        Assert.assertEquals(seaUiMock.number, apiSea.number)
        Assert.assertEquals(seaUiMock.rarity, apiSea.rarity)
        Assert.assertEquals(seaUiMock.renderUrl, apiSea.renderUrl)
        Assert.assertEquals(seaUiMock.sellNook, apiSea.sellNook)
        Assert.assertEquals(seaUiMock.shadowSize, apiSea.shadowSize)
        Assert.assertEquals(seaUiMock.tankLength, apiSea.tankLength)
        Assert.assertEquals(seaUiMock.tankWidth, apiSea.tankWidth)
        Assert.assertEquals(seaUiMock.totalCatch, apiSea.totalCatch)
        Assert.assertEquals(seaUiMock.url, apiSea.url)
        Assert.assertEquals(seaUiMock.catchSea, apiSea.catchSea)
    }

    @Test
    fun `mapSeaApiToUi should correctly map list of SeaResponseItem to list of SeaUiModel`() {
        val uiSeaList = mapper.mapSeaApiToUi(apiSeaListMock)

        Assert.assertEquals(apiSeaListMock.size, uiSeaList.size)
        for (i in apiSeaListMock.indices) {
            val apiSea = apiSeaListMock[i]
            val uiSea = uiSeaList[i]
            Assert.assertEquals(apiSea.imageUrl, uiSea.imageUrl)
            Assert.assertEquals(apiSea.name, uiSea.name)
            Assert.assertEquals(apiSea.number, uiSea.number)
            Assert.assertEquals(apiSea.rarity, uiSea.rarity)
            Assert.assertEquals(apiSea.renderUrl, uiSea.renderUrl)
            Assert.assertEquals(apiSea.sellNook, uiSea.sellNook)
            Assert.assertEquals(apiSea.tankLength, uiSea.tankLength)
            Assert.assertEquals(apiSea.tankWidth, uiSea.tankWidth)
            Assert.assertEquals(apiSea.totalCatch, uiSea.totalCatch)
            Assert.assertEquals(apiSea.url, uiSea.url)
            Assert.assertEquals(apiSea.catchSea, uiSea.catchSea)
        }
    }

}