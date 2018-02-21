package com.siddapps.android.p97.network

import com.siddapps.android.p97.data.APIResponse
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface APIInterface {

    @GET("strings")
    fun getStringDictionary(
            @Query("tenantId") tenantID: String,
            @Query("version") version: String): Observable<APIResponse>

}