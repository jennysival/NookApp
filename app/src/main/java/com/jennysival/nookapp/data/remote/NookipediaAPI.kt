package com.jennysival.nookapp.data.remote

import com.jennysival.nookapp.data.remote.bugs.BugsResponse
import com.jennysival.nookapp.data.remote.fishes.FishesResponse
import com.jennysival.nookapp.data.remote.gyroids.GyroidsResponse
import com.jennysival.nookapp.data.remote.sea.SeaResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface NookipediaAPI {

    @GET("/nh/bugs")
    suspend fun getBugs(): BugsResponse

    @GET("/nh/fish")
    suspend fun getFishes(): FishesResponse

    @GET("/nh/sea")
    suspend fun getSea(): SeaResponse

    @GET("/nh/gyroids")
    suspend fun getGyroids(): GyroidsResponse
}