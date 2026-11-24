package com.kdraw.russian

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView

class GlossaryActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val scroll = ScrollView(this)
        val list = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(32, 32, 32, 32)
        }

        list.addView(TextView(this).apply {
            text = "Русский словарь KDraw"
            textSize = 24f
            setPadding(0, 0, 0, 20)
        })

        TranslationGlossary.entries.forEach { (en, ru) ->
            list.addView(TextView(this).apply {
                text = "$en  —  $ru"
                textSize = 17f
                setPadding(0, 12, 0, 12)
            })

            list.addView(View(this).apply {
                setBackgroundColor(0xFFE0E0E0.toInt())
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, 1
                )
            })
        }

        scroll.addView(list)
        setContentView(scroll)
    }
}
