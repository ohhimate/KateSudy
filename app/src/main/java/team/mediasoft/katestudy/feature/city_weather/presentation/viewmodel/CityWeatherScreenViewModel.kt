package team.mediasoft.katestudy.feature.splash.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject
import team.mediasoft.katestudy.baseapp.presentation.viewmodel.BaseViewModel
import team.mediasoft.katestudy.baseapp.utils.data.DefaultSingleSubscriber
import team.mediasoft.katestudy.baseapp.utils.debugLog
import team.mediasoft.katestudy.baseapp.weather.domain.interactor.WeatherInteractor
import team.mediasoft.katestudy.baseapp.weather.domain.model.CityWeather
/*
fun <T> Single<T>.toLiveData(): MutableLiveData<T>{
    val liveData = MutableLiveData<T>()
    val subscriber = DefaultSingleSubscriber<T>(
        onSuccess = {
            debugLog("Data: $it")
            liveData.value = it
        }
    )
    return liveData
}
*/
class CityWeatherScreenViewModel
@Inject constructor(
    private val weatherInteractor: WeatherInteractor
) : BaseViewModel() {

    private val weatherMutableLiveData = MutableLiveData<CityWeather>()
    val weatherLiveData: LiveData<CityWeather> = weatherMutableLiveData

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    init {
        weatherMutableLiveData.value = null
    }

    private fun subscribeToCityWeather() {
        val subscriber = DefaultSingleSubscriber<CityWeather>(
            onSuccess = {
                debugLog("Data: $it")
                weatherMutableLiveData.value = it
            }
        )

        compositeDisposable.add(
            subscriber.subscribe(weatherInteractor.getCityWeather(536203)
            )
        )
    }

    override fun onBind() {
        subscribeToCityWeather()
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}


