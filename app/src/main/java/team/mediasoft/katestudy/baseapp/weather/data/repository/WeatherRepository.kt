package team.mediasoft.katestudy.baseapp.weather.data.repository

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import team.mediasoft.katestudy.BuildConfig
import team.mediasoft.katestudy.baseapp.weather.data.dto.WeatherResponse
import team.mediasoft.katestudy.baseapp.weather.data.service.MainService
import javax.inject.Inject

private const val METRIC = "metric"

interface WeatherRepository {

    fun getWeather(id: Int): Single<WeatherResponse>
}

class WeatherRepositoryImpl
@Inject constructor(
    private val weatherService: MainService
) : WeatherRepository {

    override fun getWeather(id: Int): Single<WeatherResponse> {
        return weatherService.getWeather(id, METRIC, BuildConfig.API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}

