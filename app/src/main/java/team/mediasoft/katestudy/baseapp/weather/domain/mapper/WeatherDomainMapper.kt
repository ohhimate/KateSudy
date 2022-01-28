package team.mediasoft.katestudy.baseapp.weather.domain.mapper

import team.mediasoft.katestudy.baseapp.weather.data.dto.DataResponse
import team.mediasoft.katestudy.baseapp.weather.domain.model.CityWeather
import javax.inject.Inject
import kotlin.math.roundToInt

class WeatherDomainMapper @Inject constructor() {

    fun map(response: DataResponse): CityWeather {
        return CityWeather(
            response.name,
            response.main.temp.roundToInt(),
            response.main.feels_like.roundToInt()
        )
    }
}