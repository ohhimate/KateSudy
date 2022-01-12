package team.mediasoft.katestudy.baseapp.presentation.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

const val TEST_TAG = "TEST_TAG"

abstract class BaseActivity : AppCompatActivity() {

    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        Log.d(TEST_TAG, this.javaClass.simpleName + ".onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TEST_TAG, this.javaClass.simpleName + ".onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TEST_TAG, this.javaClass.simpleName + ".onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TEST_TAG, this.javaClass.simpleName + ".onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TEST_TAG, this.javaClass.simpleName + ".onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TEST_TAG, this.javaClass.simpleName + ".onDestroy")
    }
}