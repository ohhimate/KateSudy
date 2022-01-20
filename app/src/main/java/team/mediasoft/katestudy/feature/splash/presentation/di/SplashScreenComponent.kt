package team.mediasoft.katestudy.feature.splash.presentation.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.multibindings.IntoMap
import team.mediasoft.katestudy.baseapp.presentation.di.ScreenScope
import team.mediasoft.katestudy.feature.splash.data.service.TimerService
import team.mediasoft.katestudy.feature.splash.data.service.TimerServiceImpl
import team.mediasoft.katestudy.feature.splash.presentation.viewmodel.SplashScreenViewModel
import team.mediasoft.katestudy.baseapp.presentation.viewmodel.ViewModelFactory

@Component(modules = [SplashScreenModule::class])
@ScreenScope
interface SplashScreenComponent {

    fun viewModelFactory(): ViewModelFactory
}

@Module
interface SplashScreenModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashScreenViewModel::class)
    fun bindSplashScreenViewModel(viewModel: SplashScreenViewModel): ViewModel

    @Binds
    fun bindTimerService(timerServiceImpl : TimerServiceImpl): TimerService
}