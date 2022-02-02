package team.mediasoft.katestudy.feature.splash.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject
import team.mediasoft.katestudy.baseapp.presentation.viewmodel.BaseViewModel
import team.mediasoft.katestudy.feature.splash.data.repository.TimerRepository
import team.mediasoft.katestudy.baseapp.utils.data.DefaultObservableSubscriber
import team.mediasoft.katestudy.baseapp.utils.debugLog

class SplashScreenViewModel
@Inject constructor(
    private val repository: TimerRepository
) : BaseViewModel() {

    private val timerMutableLiveData = MutableLiveData<Int>()
    val timerLiveData: LiveData<Int> = timerMutableLiveData

    private val _isCompleted = MutableLiveData<Boolean>()
    val isCompleted: LiveData<Boolean> = _isCompleted

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    init {
        _isCompleted.value = false
    }

    private fun subscribeToTimer() {
        val subscriber = DefaultObservableSubscriber<Int>(
            onNext = {
                debugLog("Next int: $it")
                timerMutableLiveData.value = it
            },
            onComplete = {
                debugLog("Splash timer completed")
                _isCompleted.value = true
            }
        )

        compositeDisposable.add(
            subscriber.subscribe(repository.getTimer())
        )
    }

    override fun onBind() {
        subscribeToTimer()
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}


