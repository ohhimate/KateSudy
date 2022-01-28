package team.mediasoft.katestudy.baseapp.weather.domain.model

data class CityWeather(
    val cityName: String,
    val temp: Int,
    val feelsLike: Int
)