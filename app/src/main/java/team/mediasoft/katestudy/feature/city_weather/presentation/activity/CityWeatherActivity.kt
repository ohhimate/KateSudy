package team.mediasoft.katestudy.feature.city_weather.presentation.activity

import android.os.Bundle
import androidx.activity.viewModels
import team.mediasoft.katestudy.R
import team.mediasoft.katestudy.baseapp.presentation.activity.BaseActivity
import team.mediasoft.katestudy.baseapp.presentation.di.DI
import team.mediasoft.katestudy.baseapp.utils.debugLog
import team.mediasoft.katestudy.baseapp.weather.domain.model.CityWeather
import team.mediasoft.katestudy.databinding.ActivityCityWeatherBinding
import team.mediasoft.katestudy.feature.city_weather.presentation.di.DaggerCityWeatherComponent
import team.mediasoft.katestudy.feature.splash.presentation.viewmodel.CityWeatherScreenViewModel

class CityWeatherActivity : BaseActivity() {

    fun getLayoutId(): Int = R.layout.activity_city_weather

    private lateinit var binding: ActivityCityWeatherBinding

    private val component by lazy {
        DaggerCityWeatherComponent.builder()
            .bindMainService(DI.appComponent.mainService())
            .build()
    }

    private val cityWeatherViewModel by viewModels<CityWeatherScreenViewModel> { component.viewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityCityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)
        subscribeToCityWeather()
    }

    private fun subscribeToCityWeather() {
        cityWeatherViewModel.weatherLiveData.observe(this, ::onLoadingWeatherUpdate)
    }

    private fun onLoadingWeatherUpdate(value: CityWeather) {
        debugLog("Hello")
    }

}