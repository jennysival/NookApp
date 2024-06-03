package com.jennysival.nookapp.data.local.gyroids

import androidx.room.Embedded
import androidx.room.Relation

data class GyroidWithVariations(
    @Embedded
    val gyroid: DbGyroid,
    @Relation(
        parentColumn = "gyroidId",
        entityColumn = "gyroidId"
    )
    val variations: List<DbVariation>
)