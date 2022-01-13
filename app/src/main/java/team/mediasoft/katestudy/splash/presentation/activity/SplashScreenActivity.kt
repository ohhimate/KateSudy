package team.mediasoft.katestudy.splash.presentation.activity

import android.os.Bundle
import androidx.activity.viewModels
import team.mediasoft.katestudy.R
import team.mediasoft.katestudy.baseapp.presentation.activity.BaseActivity
import team.mediasoft.katestudy.splash.presentation.presenter.TimerViewModel

class SplashScreenActivity : BaseActivity() {

    //получаем доступ к вм с помощью делегата
    private val timerViewModel: TimerViewModel by viewModels()

    override fun getLayoutId() = R.layout.activity_splash_screen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //подписываемся на ЛД
        timerViewModel.timer.observe(this, {
            //TODO("Next commit")
        })
        timerViewModel.isCompleted.observe(this, {
            //TODO("Next commit")
        })
    }
}
