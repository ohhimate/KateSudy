package team.mediasoft.katestudy.splash.data.service

import io.reactivex.rxjava3.core.Observable

class TimerServiceImpl : TimerService {

    override fun getTimer(): Observable<Int> {
        return Observable.create { subscriber ->
            for (i in 1..100) {
                Thread.sleep(40)
                subscriber.onNext(i)
            }
        }
    }
}