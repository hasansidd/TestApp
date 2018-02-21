package com.siddapps.android.p97

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.siddapps.android.p97.data.Dictionary
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_view.setOnClickListener({
            text_view.text = Dictionary.instance?.changePasswordErrorTitle
        })

    }
}