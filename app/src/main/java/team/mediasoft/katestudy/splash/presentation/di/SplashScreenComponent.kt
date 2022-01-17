package team.mediasoft.katestudy.splash.presentation.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.multibindings.IntoMap
import team.mediasoft.katestudy.splash.presentation.presenter.TimerViewModel
import team.mediasoft.katestudy.splash.presentation.repository.TimerRepository
import team.mediasoft.katestudy.utils.ViewModelFactory

@Component(modules = [SplashScreenModule::class])
@ScreenScope
interface SplashScreenComponent {

    fun viewModelFactory(): ViewModelFactory

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun repository(timerRepository: TimerRepository): Builder

        fun build(): SplashScreenComponent
    }
}

@Module
abstract class SplashScreenModule {

    @Binds
    @IntoMap
    @ViewModelKey(TimerViewModel::class)
    abstract fun splashScreenViewModel(viewModel: TimerViewModel): ViewModel
}