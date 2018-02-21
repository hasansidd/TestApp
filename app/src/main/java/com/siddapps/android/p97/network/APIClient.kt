package com.siddapps.android.p97.network

import android.util.Log
import com.google.gson.GsonBuilder
import com.siddapps.android.p97.data.APIResponse
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Subscriber
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class APIClient {
    private val BASE_URL = "https://api-lab.petrozone.com/app/v1/"
    private val TENANT_ID = "00000000-0000-0000-0000-000000000000"
    private val VERSION = "0"
    private val gson = GsonBuilder().setLenient().create()
    private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()
    private val api = retrofit.create(APIInterface::class.java)

    fun getStringDictionary(callback: GetStringDictionaryCallback): Subscription {
        return api.getStringDictionary(TENANT_ID, VERSION).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Subscriber<APIResponse>() {
                    override fun onCompleted() {
                        println("completed")
                    }

                    override fun onError(e: Throwable?) {
                        callback.onError(e)
                    }

                    override fun onNext(apiResponse: APIResponse?) {
                        callback.onSuccess(apiResponse)
                    }

                })
    }

    interface GetStringDictionaryCallback {
        fun onSuccess(apiResponse: APIResponse?)

        fun onError(e: Throwable?)
    }


}