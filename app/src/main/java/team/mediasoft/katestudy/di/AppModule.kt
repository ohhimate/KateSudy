package team.mediasoft.katestudy.di

import dagger.Module
import dagger.Provides
import team.mediasoft.katestudy.splash.data.service.TimerServiceImpl
import team.mediasoft.katestudy.splash.presentation.repository.TimerRepository

@Module
class AppModule {

    @Provides
    fun provideTimerServiceImpl(): TimerServiceImpl {
        return TimerServiceImpl()
    }

    @Provides
    fun provideTimerRepository(timerServiceImpl: TimerServiceImpl): TimerRepository {
        return TimerRepository(timerServiceImpl)
    }
}