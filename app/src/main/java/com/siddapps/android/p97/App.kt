package com.siddapps.android.p97

import android.app.Application
import android.util.Log
import com.siddapps.android.p97.data.APIResponse
import com.siddapps.android.p97.data.Dictionary
import com.siddapps.android.p97.network.APIClient

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        val client = APIClient()
        client.getStringDictionary(object : APIClient.GetStringDictionaryCallback {
            override fun onSuccess(apiResponse: APIResponse?) {
                Dictionary.instance = apiResponse?.stringDictionary
            }

            override fun onError(e: Throwable?) {
                Log.e("MAIN", "error", e)
            }

        })
    }

}