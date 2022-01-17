package team.mediasoft.katestudy.di

import dagger.Component
import team.mediasoft.katestudy.splash.presentation.repository.TimerRepository
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {

    fun timerRepository(): TimerRepository
}