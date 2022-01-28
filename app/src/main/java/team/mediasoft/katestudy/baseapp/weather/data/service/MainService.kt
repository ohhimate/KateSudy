package team.mediasoft.katestudy.baseapp.weather.data.service

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query
import team.mediasoft.katestudy.baseapp.weather.data.dto.DataResponse

const val BASE_URL = "https://api.openweathermap.org/"

interface MainService {

    @GET("data/2.5/weather")    //?id=536203&appid=4d0a72df8fb92392761c2d9d14590056&units=metric
    fun getWeather(
        @Query("id") id: Int,
        @Query("units") units: String,
        @Query("appid") appid: String
    ): Single<DataResponse>
}