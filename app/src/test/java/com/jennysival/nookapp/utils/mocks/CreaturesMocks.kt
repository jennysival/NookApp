package com.jennysival.nookapp.utils.mocks

import com.jennysival.nookapp.data.remote.bugs.BugsResponseItem
import com.jennysival.nookapp.data.remote.fishes.FishesResponseItem
import com.jennysival.nookapp.data.remote.sea.SeaResponseItem
import com.jennysival.nookapp.ui.creatures.bugs.BugsUiModel
import com.jennysival.nookapp.ui.creatures.fishes.FishesUiModel
import com.jennysival.nookapp.ui.creatures.sea.SeaUiModel

val bugsUiMock = BugsUiModel(
    imageUrl = "",
    location = "",
    name = "",
    number = 1,
    rarity = "",
    renderUrl = "",
    sellFlick = 50,
    sellNook = 20,
    tankLength = 1,
    tankWidth = 2,
    totalCatch = 3,
    url = "",
    catchBug = true
)

val fishUiMock = FishesUiModel(
    imageUrl = "",
    location = "",
    name = "",
    number = 1,
    rarity = "",
    renderUrl = "",
    sellCj = 50,
    sellNook = 20,
    shadowSize = "",
    tankLength = 1,
    tankWidth = 2,
    totalCatch = 3,
    url = "",
    catchFish = true
)

val seaUiMock = SeaUiModel(
    imageUrl = "",
    name = "",
    number = 1,
    rarity = "",
    renderUrl = "",
    sellNook = 50,
    shadowMovement = "",
    shadowSize = "",
    tankLength = 1,
    tankWidth = 2,
    totalCatch = 3,
    url = "",
    catchSea = true
)

val apiBugsListMock = listOf(
    BugsResponseItem(
        imageUrl = "image1",
        location = "local1",
        name = "name1",
        number = 1,
        rarity = "rare",
        renderUrl = "render",
        sellFlick = 50,
        sellNook = 20,
        tankLength = 1,
        tankWidth = 2,
        totalCatch = 3,
        url = "url",
        catchBug = true
    ),
    BugsResponseItem(
        imageUrl = "image2",
        location = "local2",
        name = "name2",
        number = 2,
        rarity = "common",
        renderUrl = "render2",
        sellFlick = 60,
        sellNook = 30,
        tankLength = 2,
        tankWidth = 3,
        totalCatch = 4,
        url = "url2",
        catchBug = false
    )
)

val apiFishesListMock = listOf(
    FishesResponseItem(
        imageUrl = "image1",
        location = "local1",
        name = "name1",
        number = 1,
        rarity = "rare",
        renderUrl = "render1",
        sellCj = 50,
        sellNook = 20,
        shadowSize = "size1",
        tankLength = 1,
        tankWidth = 2,
        totalCatch = 3,
        url = "url",
        catchFish = true
    ),
    FishesResponseItem(
        imageUrl = "image2",
        location = "local2",
        name = "name2",
        number = 2,
        rarity = "common",
        renderUrl = "render2",
        sellCj = 60,
        sellNook = 30,
        shadowSize = "size2",
        tankLength = 2,
        tankWidth = 3,
        totalCatch = 4,
        url = "url2",
        catchFish = false
    )
)

val apiSeaListMock = listOf(
    SeaResponseItem(
        imageUrl = "image1",
        name = "name1",
        number = 1,
        rarity = "rare",
        renderUrl = "render1",
        sellNook = 50,
        shadowMovement = "move1",
        shadowSize = "size1",
        tankLength = 1,
        tankWidth = 2,
        totalCatch = 3,
        url = "url1",
        catchSea = true
    ),
    SeaResponseItem(
        imageUrl = "image2",
        name = "name2",
        number = 2,
        rarity = "common",
        renderUrl = "render2",
        sellNook = 60,
        shadowMovement = "move2",
        shadowSize = "size2",
        tankLength = 2,
        tankWidth = 3,
        totalCatch = 4,
        url = "url2",
        catchSea = false
    )
)