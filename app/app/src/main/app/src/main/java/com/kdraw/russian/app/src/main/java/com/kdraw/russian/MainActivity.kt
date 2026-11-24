
package com.kdraw.russian

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(32, 32, 32, 32)
        }

        layout.addView(TextView(this).apply {
            text = "KDraw — русский перевод"
            textSize = 24f
        })

        layout.addView(TextView(this).apply {
            text = "Проверочная версия русификатора. Здесь пока доступен словарь переводов."
            textSize = 16f
        })

        layout.addView(Button(this).apply {
            text = "Открыть словарь"
            setOnClickListener {
                startActivity(Intent(this@MainActivity, GlossaryActivity::class.java))
            }
        })

        layout.addView(Button(this).apply {
            text = "Разрешение поверх окон"
            setOnClickListener {
                if (!Settings.canDrawOverlays(this@MainActivity)) {
                    startActivity(
                        Intent(
                            Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                            Uri.parse("package:$packageName")
                        )
                    )
                }
            }
        })

        setContentView(layout)
    }
}
