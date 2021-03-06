package team.mediasoft.katestudy.feature.splash.data.repository

import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import team.mediasoft.katestudy.feature.splash.data.service.TimerService
import javax.inject.Inject

class TimerRepository
@Inject constructor(
    private val timerService: TimerService
) {

    fun getTimer(): Observable<Int> {
        return timerService.getTimer()
            .subscribeOn(Schedulers.io())
    }
}
