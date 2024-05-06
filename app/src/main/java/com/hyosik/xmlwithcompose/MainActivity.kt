package com.hyosik.xmlwithcompose

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.widget.AppCompatButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.ComposeView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hyosik.xmlwithcompose.component.SampleDialog

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val view = findViewById<View>(R.id.water)

        findViewById<ComposeView>(R.id.dialog_compose).setContent {
            MaterialTheme {
                Surface {
                    var openDialog by remember { mutableStateOf(false) }

                    findViewById<AppCompatButton>(R.id.dialog_button).setOnClickListener {
                        openDialog = true
                    }

                    SampleDialog(openDialog) {
                        openDialog = false
                    }
                }
            }
        }

        Handler(Looper.getMainLooper()).postDelayed({
            val density = this.resources.displayMetrics.density
            val params = view.layoutParams as ConstraintLayout.LayoutParams
            params.height = (60 * density).toInt()
            view.layoutParams = params
        }, 4000)

    }
}