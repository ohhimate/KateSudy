package team.mediasoft.katestudy.baseapp.weather.domain.interactor

import io.reactivex.rxjava3.core.Single
import team.mediasoft.katestudy.baseapp.weather.domain.model.CityWeather

interface WeatherInteractor {

    fun getCityWeather(cityId: Int): Single<CityWeather>
}