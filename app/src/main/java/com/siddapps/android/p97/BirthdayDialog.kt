package com.siddapps.android.p97

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.widget.Toast
import com.siddapps.android.p97.data.APIResponse
import com.siddapps.android.p97.data.Dictionary
import com.siddapps.android.p97.network.APIClient
import kotlinx.android.synthetic.main.activity_main.*

class BirthdayDialog(private val c: Context?) : Dialog(c) {
    val TAG = "BirthdayDialog"

    init {
        var dictionary = Dictionary.instance
    }

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
        Log.e(TAG,Dictionary.instance?.interviewTestKey1)
        text_1.text = Dictionary.instance?.interviewTestKey1
        text_2.text = Dictionary.instance?.interviewTestKey2
        cta1.text = Dictionary.instance?.interviewTestKey3
        cta2.text = Dictionary.instance?.interviewTestKey4

        cta1.setOnClickListener({
            Log.e(TAG, c.toString())
            Snackbar.make((c as MainActivity2).findViewById(R.id.frame), Dictionary.instance!!.interviewTestKey5, Snackbar.LENGTH_SHORT).show()

           // Toast.makeText(c, Dictionary.instance?.interviewTestKey5, Toast.LENGTH_LONG)
        })

        cta2.setOnClickListener({
            Snackbar.make((c as MainActivity2).findViewById(R.id.frame), Dictionary.instance!!.interviewTestKey6, Snackbar.LENGTH_SHORT).show()
        })
    }
}