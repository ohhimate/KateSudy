package team.mediasoft.katestudy.di

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
