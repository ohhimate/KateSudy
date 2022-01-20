package team.mediasoft.katestudy.splash.presentation.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.multibindings.IntoMap
import team.mediasoft.katestudy.di.ScreenScope
import team.mediasoft.katestudy.splash.data.service.TimerService
import team.mediasoft.katestudy.splash.data.service.TimerServiceImpl
import team.mediasoft.katestudy.splash.presentation.presenter.TimerViewModel
import team.mediasoft.katestudy.utils.ViewModelFactory

@Component(modules = [SplashScreenModule::class])
@ScreenScope
interface SplashScreenComponent {

    fun viewModelFactory(): ViewModelFactory
}

@Module
interface SplashScreenModule {

    @Binds
    @IntoMap
    @ViewModelKey(TimerViewModel::class)
    fun bindSplashScreenViewModel(viewModel: TimerViewModel): ViewModel

    @Binds
    fun bindTimerService(timerServiceImpl : TimerServiceImpl): TimerService

}