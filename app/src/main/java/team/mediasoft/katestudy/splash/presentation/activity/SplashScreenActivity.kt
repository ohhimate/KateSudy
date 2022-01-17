package team.mediasoft.katestudy.splash.presentation.activity

import android.os.Bundle
import androidx.activity.viewModels
import team.mediasoft.katestudy.DI
import team.mediasoft.katestudy.R
import team.mediasoft.katestudy.baseapp.presentation.activity.BaseActivity
import team.mediasoft.katestudy.splash.presentation.di.DaggerSplashScreenComponent
import team.mediasoft.katestudy.splash.presentation.presenter.TimerViewModel

class SplashScreenActivity : BaseActivity() {

    private val component by lazy {
        DaggerSplashScreenComponent.builder()
            .repository(DI.appComponent.timerRepository())
            .build()
    }

    private val timerViewModel by viewModels<TimerViewModel> { component.viewModelFactory() }

    override fun getLayoutId() = R.layout.activity_splash_screen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subscribeToTimer()
        subscribeToLiveData()
    }

    private fun subscribeToTimer() {
        timerViewModel.subscribeToTimer()
    }

    private fun subscribeToLiveData() {
        timerViewModel.timer.observe(this, {
            //TODO("Next commit")
        })
        timerViewModel.isCompleted.observe(this, {
            //TODO("Next commit")
        })
    }
}
