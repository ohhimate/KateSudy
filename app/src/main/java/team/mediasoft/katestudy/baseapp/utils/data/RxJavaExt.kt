package team.mediasoft.katestudy.baseapp.utils.data

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import team.mediasoft.katestudy.baseapp.utils.errorLog

class DefaultObservableSubscriber<T>(
    private val onNext: ((T) -> Unit)? = null,
    private val onComplete: (() -> Unit)? = null,
    private val errorProcessor: ErrorProcessor = DefaultErrorProcessor()
) {
    fun subscribe(event: Observable<T>) {
        event.observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                onNext,
                errorProcessor::onErrorReceived,
                onComplete
            )
    }
}

interface ErrorProcessor {
    fun onErrorReceived(t: Throwable)
}

class DefaultErrorProcessor: ErrorProcessor {
    override fun onErrorReceived(t: Throwable) {
       errorLog(t)
    }
}