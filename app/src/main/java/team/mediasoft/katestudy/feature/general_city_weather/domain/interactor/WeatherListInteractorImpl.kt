package team.mediasoft.katestudy.feature.general_city_weather.domain.interactor

import io.reactivex.rxjava3.core.Single
import team.mediasoft.katestudy.baseapp.weather.domain.interactor.WeatherInteractor
import team.mediasoft.katestudy.baseapp.weather.domain.model.CityWeather
import javax.inject.Inject

class WeatherListInteractorImpl @Inject constructor(
    private val weatherInteractor: WeatherInteractor
) : WeatherListInteractor {

    override fun getGeneralWeather(cityIds: List<Int>): Map<Int,Single<CityWeather>> {
        val result = mutableMapOf<Int,Single<CityWeather>>()
        for (i in cityIds) {
            result[i] = weatherInteractor.getCityWeather(i)
        }
        return result
    }
}