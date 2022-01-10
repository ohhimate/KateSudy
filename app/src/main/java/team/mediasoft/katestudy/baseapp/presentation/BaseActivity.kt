package team.mediasoft.katestudy.baseapp.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

const val LIFECYCLE = "Lifecycle"

abstract class BaseActivity : AppCompatActivity() {

    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        Log.d(LIFECYCLE, this.javaClass.simpleName + ".onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(LIFECYCLE, this.javaClass.simpleName + ".onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LIFECYCLE, this.javaClass.simpleName + ".onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LIFECYCLE, this.javaClass.simpleName + ".onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LIFECYCLE, this.javaClass.simpleName + ".onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LIFECYCLE, this.javaClass.simpleName + ".onDestroy")
    }
}