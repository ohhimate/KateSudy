package team.mediasoft.katestudy.feature.splash.presentation.activity

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.viewModels
import team.mediasoft.katestudy.baseapp.presentation.activity.BaseActivity
import team.mediasoft.katestudy.baseapp.presentation.di.DI
import team.mediasoft.katestudy.baseapp.utils.debugLog
import team.mediasoft.katestudy.baseapp.utils.errorLog
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

    private val lowBatteryReceiver = DI.appComponent.airplaneModeReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        subscribeToLiveData()
        binding.splashScreenBtnToCityW.setOnClickListener {
            btnToCityWOnClick()
        }
    }

    override fun onResume() {
        super.onResume()
        registerAirplaneModeBroadcastReceiver()
    }

    override fun onPause() {
        super.onPause()
        try {
            unregisterAirplaneModeBroadcastReceiver()
        } catch (e: IllegalArgumentException) {
            errorLog(e,"Low Battery Receiver not registered")
        }
    }

    private fun btnToCityWOnClick() {
        val intent = Intent(this, CityWeatherActivity::class.java)
        startActivity(intent)
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

    private fun registerAirplaneModeBroadcastReceiver() {
        registerReceiver(lowBatteryReceiver, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))
        debugLog("Приёмник включен")
    }

    private fun unregisterAirplaneModeBroadcastReceiver() {
        unregisterReceiver(lowBatteryReceiver)
        debugLog("Приёмник выключен")
    }
}
