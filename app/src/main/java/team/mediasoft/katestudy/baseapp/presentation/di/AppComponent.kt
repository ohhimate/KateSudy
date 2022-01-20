package team.mediasoft.katestudy.baseapp.presentation.di

import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {
}

@Module
class AppModule {
}
