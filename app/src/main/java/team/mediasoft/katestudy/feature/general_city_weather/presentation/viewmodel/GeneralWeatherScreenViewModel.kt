package team.mediasoft.katestudy.feature.splash.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject
import team.mediasoft.katestudy.baseapp.presentation.viewmodel.BaseViewModel
import team.mediasoft.katestudy.baseapp.weather.domain.model.CityWeather
import team.mediasoft.katestudy.feature.general_city_weather.domain.interactor.WeatherListInteractor

class GeneralWeatherScreenViewModel
@Inject constructor(
    private val weatherListInteractor: WeatherListInteractor
) : BaseViewModel() {

    private val weatherMutableLiveData = MutableLiveData<CityWeather>()
    val weatherLiveData: LiveData<CityWeather> = weatherMutableLiveData

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    init {
        weatherMutableLiveData.value = null
    }

    override fun onBind() {
        //subsubscribeToDatascribeToTimer()
    }
/*
    private fun subscribeToData() {
        val subscriber = DefaultObservableSubscriber<CityWeather>(
            onNext = {
                debugLog("Next int: $it")
                weatherMutableLiveData.value = it
            }
        )

        compositeDisposable.add(
            subscriber.subscribe(repository.getTimer())
        )
    }

    override fun onBind() {
        subsubscribeToDatascribeToTimer()
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
*/
}


