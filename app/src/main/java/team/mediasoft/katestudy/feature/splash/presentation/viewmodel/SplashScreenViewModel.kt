package team.mediasoft.katestudy.feature.splash.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject
import team.mediasoft.katestudy.baseapp.presentation.viewmodel.BaseViewModel
import team.mediasoft.katestudy.feature.splash.data.repository.TimerRepository
import team.mediasoft.katestudy.baseapp.utils.data.DefaultObservableSubscriber
import team.mediasoft.katestudy.baseapp.utils.debugLog

class SplashScreenViewModel
@Inject constructor(
    private val repository: TimerRepository
) : BaseViewModel() {

    private val _timer = MutableLiveData<Int>()
    val timer: LiveData<Int> = _timer

    private val _isCompleted = MutableLiveData<Boolean>()
    val isCompleted: LiveData<Boolean> = _isCompleted

    init {
        _isCompleted.value = false
    }

    private fun subscribeToTimer() {
        val subscriber = DefaultObservableSubscriber<Int>(
            onNext = {
                debugLog("Next int: $it")
                _timer.value = it
            },
            onComplete = {
                debugLog("Splash timer completed")
                _isCompleted.value = true
            }
        )
        subscriber.subscribe(repository.getTimer())
    }

    override fun onBind() {
        subscribeToTimer()
    }
}
