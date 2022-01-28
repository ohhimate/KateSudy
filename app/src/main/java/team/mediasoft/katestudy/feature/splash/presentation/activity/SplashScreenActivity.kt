package team.mediasoft.katestudy.feature.splash.presentation.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import team.mediasoft.katestudy.baseapp.presentation.activity.BaseActivity
import team.mediasoft.katestudy.databinding.ActivitySplashScreenBinding
import team.mediasoft.katestudy.feature.splash.presentation.viewmodel.SplashScreenViewModel
import team.mediasoft.katestudy.baseapp.utils.presentation.view.makeGone
import team.mediasoft.katestudy.baseapp.utils.presentation.view.makeVisible
import team.mediasoft.katestudy.feature.city_weather.presentation.activity.CityWeatherActivity
import team.mediasoft.katestudy.feature.splash.presentation.di.DaggerSplashScreenComponent

class SplashScreenActivity : BaseActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    private val component by lazy {
        DaggerSplashScreenComponent.create()
    }
    private val timerViewModel by viewModels<SplashScreenViewModel> { component.viewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        subscribeToLiveData()
        binding.splashScreenBtnToCityW.setOnClickListener {
            btnToCityWOnClick()
        }

    }

    private fun btnToCityWOnClick() {
        val i = Intent(this, CityWeatherActivity::class.java)
        startActivity(i)
    }

    private fun subscribeToLiveData() {
        timerViewModel.timerLiveData.observe(this, ::onLoadingProgressUpdate)
        timerViewModel.isCompleted.observe(this, ::onLoadingComplete)
    }

    private fun onLoadingProgressUpdate(value: Int) {
        binding.splashScreenProgressBar.progress = value
    }

    private fun onLoadingComplete(isComplete: Boolean) {
        if (isComplete) showButtons()
    }

    private fun showButtons() {
        with(binding) {
            splashScreenProgressBar.makeGone()
            splashScreenBtnToGenW.makeVisible()
            splashScreenBtnToCityW.makeVisible()
        }
    }

}
