package com.jennysival.nookapp.data.remote

import com.jennysival.nookapp.data.remote.bugs.BugsResponse
import com.jennysival.nookapp.data.remote.fishes.FishesResponse
import com.jennysival.nookapp.data.remote.sea.SeaResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface NookipediaAPI {

    @Headers(
        "X-API-KEY: ${RetrofitService.API_KEY}",
        "Accept-Version: 1.7.0"
    )
    @GET("/nh/bugs")
    suspend fun getBugs(): BugsResponse

    @Headers(
        "X-API-KEY: ${RetrofitService.API_KEY}",
        "Accept-Version: 1.7.0"
    )
    @GET("/nh/fish")
    suspend fun getFishes(): FishesResponse

    @Headers(
        "X-API-KEY: ${RetrofitService.API_KEY}",
        "Accept-Version: 1.7.0"
    )
    @GET("/nh/sea")
    suspend fun getSea(): SeaResponse
}