package com.jennysival.nookapp.repository

import com.jennysival.nookapp.data.remote.RetrofitService
import com.jennysival.nookapp.data.remote.bugs.BugsResponseItem

class CreaturesRepository {

    suspend fun getBugs(): List<BugsResponseItem> {
        return RetrofitService.apiService.getBugs()
    }

}