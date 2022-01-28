package team.mediasoft.katestudy.baseapp.presentation.di

import dagger.Component
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import team.mediasoft.katestudy.baseapp.presentation.viewmodel.ViewModelFactory
import team.mediasoft.katestudy.baseapp.weather.data.service.MainService
import team.mediasoft.katestudy.baseapp.weather.data.service.BASE_URL
import javax.inject.Singleton

@Component(modules = [AppModule::class, ServiceModule::class])
@Singleton
interface AppComponent {

    fun mainService(): MainService
}

@Module
class AppModule {

}

@Module
class ServiceModule {

    @Provides
    @Singleton
    fun provideRetrofit(): MainService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
            .create(MainService::class.java)
    }
}
