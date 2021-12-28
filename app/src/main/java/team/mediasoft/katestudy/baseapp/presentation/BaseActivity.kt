package team.mediasoft.katestudy.baseapp.presentation

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.PersistableBundle
import android.service.voice.VoiceInteractionSession
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

const val LIFECYCLE = "Lifecycle"

abstract class BaseActivity : AppCompatActivity() {
    abstract fun getLayoutId(): Int


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        Log.d(LIFECYCLE, "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(LIFECYCLE, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LIFECYCLE, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LIFECYCLE, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LIFECYCLE, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LIFECYCLE, "onDestroy")
    }
}