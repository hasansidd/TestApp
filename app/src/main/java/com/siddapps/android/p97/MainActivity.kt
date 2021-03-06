package com.siddapps.android.p97

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.siddapps.android.p97.data.APIResponse
import com.siddapps.android.p97.data.Dictionary
import com.siddapps.android.p97.network.APIClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val dictionary = Dictionary.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        updateUI()

        info_button.setOnClickListener({
            val client = APIClient()
            client.getStringDictionary(object : APIClient.GetStringDictionaryCallback {
                override fun onSuccess(apiResponse: APIResponse?) {
                    Dictionary.instance = apiResponse?.stringDictionary
                    updateUI()
                }

                override fun onError(e: Throwable?) {
                    Log.e("MAIN", "error", e)
                }
            })
        })
    }

    fun updateUI() {
        text_1.text = dictionary?.interviewTestKey1
        text_2.text = dictionary?.interviewTestKey2
        cta1.text = dictionary?.interviewTestKey3
        cta2.text = dictionary?.interviewTestKey4

        cta1.setOnClickListener({
            Toast.makeText(this, dictionary?.interviewTestKey5, Toast.LENGTH_LONG)
        })

        cta2.setOnClickListener({
            Toast.makeText(this, dictionary?.interviewTestKey6, Toast.LENGTH_LONG)
        })
    }
}