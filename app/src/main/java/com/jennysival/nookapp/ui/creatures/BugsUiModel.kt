package com.jennysival.nookapp.ui.creatures

import com.jennysival.nookapp.data.remote.bugs.North
import com.jennysival.nookapp.data.remote.bugs.South

data class BugsUiModel(
    var imageUrl: String,
    var location: String,
    var name: String,
    var number: Int,
    var rarity: String,
    var renderUrl: String,
    var sellFlick: Int,
    var sellNook: Int,
    var tankLength: Int,
    var tankWidth: Int,
    var totalCatch: Int,
    var url: String,
    var catchBug: Boolean = false
)
