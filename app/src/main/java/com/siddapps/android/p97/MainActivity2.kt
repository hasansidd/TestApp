package com.siddapps.android.p97

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    val TAG = "MainActivity2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        Log.e(TAG, this.toString())
        val dialog = BirthdayDialog(this)
        button.setOnClickListener(View.OnClickListener {
            dialog.show()
        })
    }
}