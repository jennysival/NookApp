package com.jennysival.nookapp.data.local.gyroids

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = DbGyroid::class,
        parentColumns = ["gyroidId"],
        childColumns = ["gyroidId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class DbVariation(
    @PrimaryKey(autoGenerate = true) var variationId: Int = 0,
    var gyroidId: Long,
    var imageUrl: String,
    var variationName: String,
    var gotVariation: Boolean = false
)