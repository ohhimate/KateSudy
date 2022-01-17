package team.mediasoft.katestudy.splash.presentation.repository

import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import team.mediasoft.katestudy.splash.data.service.TimerServiceImpl

class TimerRepository {

    private val timerServiceImpl = TimerServiceImpl()

    fun getTimer(): Observable<Int> {
        return timerServiceImpl.getTimer()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
