package team.mediasoft.katestudy.feature.splash.data.service

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import javax.inject.Inject

class TimerServiceImpl @Inject constructor() : TimerService {

    override fun getTimer(): Observable<Int> {
        var disposable: Disposable = Disposable.disposed()

        return Observable.create<Int> { subscriber ->
            try {
                for (i in 1..100) {
                    Thread.sleep(20)
                    subscriber.onNext(i)
                }
                subscriber.onComplete()
            } catch (throwable: Throwable) {
                if (!disposable.isDisposed) {
                    subscriber.onError(throwable)
                }
            }
        }.doOnSubscribe {
            disposable = it
        }
    }
}