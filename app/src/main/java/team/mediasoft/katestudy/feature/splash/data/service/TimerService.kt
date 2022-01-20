package team.mediasoft.katestudy.feature.splash.data.service

import io.reactivex.rxjava3.core.Observable

interface TimerService {

    fun getTimer(): Observable<Int>
}