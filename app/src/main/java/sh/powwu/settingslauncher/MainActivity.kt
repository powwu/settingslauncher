package sh.powwu.settingslauncher

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import sh.powwu.settingslauncher.ui.theme.SettingsLauncherTheme
import android.os.CountDownTimer
import android.widget.Toast
import android.net.Uri
import android.provider.Settings

private lateinit var timer: CountDownTimer


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SettingsLauncherTheme {
                CreateButton(modifier = Modifier.fillMaxSize(), this)
            }
        }
            launchApp(this)
    }

}

fun launchApp(context: ComponentActivity) {
    try {
        val intent = Intent()
        intent.setClassName(
            "com.android.settings",
            "com.android.settings.Settings"
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.addFlags(Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        context.startActivity(intent)

    } catch (e: Exception) {
        e.printStackTrace()
    }

    android.os.Process.killProcess(android.os.Process.myPid())
}

@Composable
fun CreateButton(modifier: Modifier = Modifier, context: ComponentActivity) {
    Button(
        onClick = { },
        modifier = modifier,
        enabled = true,
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Black
        ),
        interactionSource = remember { MutableInteractionSource() }
    ) {
        Text(text = "Opening settings...")
    }
}
