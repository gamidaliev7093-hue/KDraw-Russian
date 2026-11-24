package com.kdraw.russian

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val pad = (20 * resources.displayMetrics.density).toInt()
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(pad, pad, pad, pad)
            gravity = Gravity.CENTER_VERTICAL
        }
        layout.addView(TextView(this).apply {
            text = "KDraw — русский перевод"
            textSize = 24f
        })
        layout.addView(TextView(this).apply {
            text = "\nЭто проверочная версия проекта. Она показывает словарь переводов, " +
                "но пока НЕ распознаёт надписи на экране KDraw и НЕ накладывает перевод поверх приложения.\n"
            textSize = 16f
        })
        layout.addView(Button(this).apply {
            text = "Открыть словарь переводов"
            setOnClickListener { startActivity(Intent(this@MainActivity, GlossaryActivity::class.java)) }
        })
        layout.addView(Button(this).apply {
            text = "Разрешение на отображение поверх окон"
            setOnClickListener {
                if (!Settings.canDrawOverlays(this@MainActivity)) {
                    startActivity(
                        Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                            Uri.parse("package:$packageName"))
                    )
                }
            }
        })
        layout.addView(TextView(this).apply {
            text = "\nСледующий этап разработки: захват экрана с разрешения пользователя, OCR, " +
                "сопоставление надписей со словарём и прозрачные переводные плашки."
            textSize = 14f
        })
        setContentView(layout)
    }
}
