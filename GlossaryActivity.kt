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
            val p = (16 * resources.displayMetrics.density).toInt()
            setPadding(p, p, p, p)
        }
        list.addView(TextView(this).apply {
            text = "Словарь KDraw"
            textSize = 24f
            setPadding(0, 0, 0, 16)
        })
        TranslationGlossary.entries.forEach { (en, ru) ->
            list.addView(TextView(this).apply {
                text = "$en  —  $ru"
                textSize = 16f
                setPadding(0, 8, 0, 8)
            })
            val divider = View(this).apply {
                setBackgroundColor(0xFFE0E0E0.toInt())
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    (1 * resources.displayMetrics.density).toInt()
                )
            }
            list.addView(divider)
        }
        scroll.addView(list)
        setContentView(scroll)
    }
}
