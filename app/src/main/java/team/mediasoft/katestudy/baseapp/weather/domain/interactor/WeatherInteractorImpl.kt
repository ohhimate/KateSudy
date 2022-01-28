package team.mediasoft.katestudy.baseapp.weather.domain.interactor

import io.reactivex.rxjava3.core.Single
import team.mediasoft.katestudy.baseapp.utils.debugLog
import team.mediasoft.katestudy.baseapp.weather.data.repository.WeatherRepository
import team.mediasoft.katestudy.baseapp.weather.domain.mapper.WeatherDomainMapper
import team.mediasoft.katestudy.baseapp.weather.domain.model.CityWeather
import javax.inject.Inject

class WeatherInteractorImpl
@Inject constructor(
    private val weatherRepository: WeatherRepository,
    private val mapper: WeatherDomainMapper
) : WeatherInteractor {

    override fun getCityWeather(cityId: Int): Single<CityWeather> {
        val a = weatherRepository.getWeather(cityId).map(mapper::map)
        debugLog("$a")
        return a
    }
}