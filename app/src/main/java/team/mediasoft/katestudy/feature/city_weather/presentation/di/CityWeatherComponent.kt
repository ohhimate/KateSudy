package team.mediasoft.katestudy.feature.city_weather.presentation.di

import androidx.lifecycle.ViewModel
import dagger.*
import dagger.multibindings.IntoMap
import team.mediasoft.katestudy.baseapp.presentation.di.ScreenScope
import team.mediasoft.katestudy.baseapp.presentation.viewmodel.ViewModelFactory
import team.mediasoft.katestudy.baseapp.weather.data.repository.WeatherRepository
import team.mediasoft.katestudy.baseapp.weather.data.repository.WeatherRepositoryImpl
import team.mediasoft.katestudy.baseapp.weather.data.service.MainService
import team.mediasoft.katestudy.baseapp.weather.domain.interactor.WeatherInteractor
import team.mediasoft.katestudy.baseapp.weather.domain.interactor.WeatherInteractorImpl
import team.mediasoft.katestudy.feature.splash.presentation.di.ViewModelKey
import team.mediasoft.katestudy.feature.splash.presentation.viewmodel.CityWeatherScreenViewModel

@Component(modules = [CityWeatherModule::class])
@ScreenScope
interface CityWeatherComponent {

    fun viewModelFactory(): ViewModelFactory

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindMainService(mainService: MainService): Builder

        fun build(): CityWeatherComponent
    }
}

@Module
interface CityWeatherModule {

    @Binds
    @IntoMap
    @ViewModelKey(CityWeatherScreenViewModel::class)
    fun bindCityWeatherScreenViewModel(viewModel: CityWeatherScreenViewModel): ViewModel

    @Binds
    fun bindWeatherInteractor(weatherInteractorImpl: WeatherInteractorImpl): WeatherInteractor

    @Binds
    fun bindWeatherRepository(WeatherRepositoryImpl: WeatherRepositoryImpl): WeatherRepository
}
