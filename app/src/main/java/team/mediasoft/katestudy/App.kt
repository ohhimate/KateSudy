package team.mediasoft.katestudy

import android.app.Application
import team.mediasoft.katestudy.di.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initDI()
    }

    private fun initDI() {
        DI.appComponent = DaggerAppComponent.create()
    }
}
