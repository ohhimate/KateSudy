package team.mediasoft.katestudy.feature.general_city_weather.domain.interactor

import io.reactivex.rxjava3.core.Single
import team.mediasoft.katestudy.baseapp.weather.domain.model.CityWeather

interface WeatherListInteractor {

    fun getGeneralWeather(cityIds: List<Int>): Map<Int,Single<CityWeather>>
}