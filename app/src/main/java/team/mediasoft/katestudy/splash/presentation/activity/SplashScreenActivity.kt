package team.mediasoft.katestudy.splash.presentation.activity

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import team.mediasoft.katestudy.R
import team.mediasoft.katestudy.baseapp.presentation.activity.BaseActivity
import team.mediasoft.katestudy.databinding.ActivitySplashScreenBinding
import team.mediasoft.katestudy.splash.presentation.di.DaggerSplashScreenComponent
import team.mediasoft.katestudy.splash.presentation.presenter.TimerViewModel

class SplashScreenActivity : BaseActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    private val component by lazy {
        DaggerSplashScreenComponent.create()
    }

    private val timerViewModel by viewModels<TimerViewModel> { component.viewModelFactory() }

    override fun getLayoutId() = R.layout.activity_splash_screen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        subscribeToTimer()
        subscribeToLiveData()
    }

    private fun subscribeToTimer() {
        timerViewModel.subscribeToTimer()
    }

    private fun subscribeToLiveData() {
        timerViewModel.timer.observe(this, {
            binding.splashScreenProgressBar.setProgress(it)
        })
        timerViewModel.isCompleted.observe(this, {
            if (it) showButtons()
        })
    }

    private fun showButtons() {
        binding.splashScreenProgressBar.visibility = View.INVISIBLE
        binding.splashScreenBtnToGenW.visibility = View.VISIBLE
        binding.splashScreenBtnToCityW.visibility = View.VISIBLE
    }

}
