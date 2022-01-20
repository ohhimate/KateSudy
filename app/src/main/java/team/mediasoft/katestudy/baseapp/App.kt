package team.mediasoft.katestudy.baseapp

import android.app.Application
import team.mediasoft.katestudy.baseapp.presentation.di.DI
import team.mediasoft.katestudy.baseapp.presentation.di.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initDI()
    }

    private fun initDI() {
        DI.appComponent = DaggerAppComponent.create()
    }
}
