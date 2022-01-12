package team.mediasoft.katestudy.splash.presentation.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import team.mediasoft.katestudy.R
import team.mediasoft.katestudy.baseapp.presentation.activity.BaseActivity
import team.mediasoft.katestudy.baseapp.presentation.activity.TEST_TAG
import team.mediasoft.katestudy.splash.presentation.presenter.TimerViewModel

class SplashScreenActivity : BaseActivity() {

    private val timerViewModel: TimerViewModel by viewModels()

    override fun getLayoutId() = R.layout.activity_splash_screen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    private fun initViewModel(){
        timerViewModel.getTimer().observe(this, {
            Log.d(TEST_TAG, "Next int: $it")
        })
    }
}
