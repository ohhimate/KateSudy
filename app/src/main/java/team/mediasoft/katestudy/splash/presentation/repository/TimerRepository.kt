package team.mediasoft.katestudy.splash.presentation.repository

import io.reactivex.rxjava3.schedulers.Schedulers
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.LiveData
import io.reactivex.rxjava3.core.BackpressureStrategy
import team.mediasoft.katestudy.splash.data.service.TimerServiceImpl

class TimerRepository {

    private val timerServiceImpl = TimerServiceImpl()

    fun getReactiveTimer(): LiveData<Int> {
        return LiveDataReactiveStreams.fromPublisher(
            timerServiceImpl.getTimer()
                .toFlowable(BackpressureStrategy.BUFFER)
                .subscribeOn(Schedulers.io())
        )
    }
}
