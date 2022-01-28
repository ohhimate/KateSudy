package team.mediasoft.katestudy.baseapp.utils.data

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.Disposable
import team.mediasoft.katestudy.baseapp.utils.errorLog

class DefaultObservableSubscriber<T>(
    private val onNext: ((T) -> Unit)? = null,
    private val onComplete: (() -> Unit)? = null,
    private val errorProcessor: ErrorProcessor = DefaultErrorProcessor()
) {
    fun subscribe(event: Observable<T>): Disposable {
        return event.observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                onNext,
                errorProcessor::onErrorReceived,
                onComplete
            )
    }
}

class DefaultSingleSubscriber<T>(
    private val onSuccess: ((T) -> Unit)? = null,
    private val errorProcessor: ErrorProcessor = DefaultErrorProcessor()
) {
    fun subscribe(event: Single<T>): Disposable {
        return event.observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                onSuccess,
                errorProcessor::onErrorReceived
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