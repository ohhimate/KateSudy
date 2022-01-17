package team.mediasoft.katestudy.splash.presentation.presenter

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import team.mediasoft.katestudy.baseapp.presentation.activity.TEST_TAG
import team.mediasoft.katestudy.splash.presentation.repository.TimerRepository
import javax.inject.Inject

class TimerViewModel @Inject constructor(private val repository: TimerRepository) : ViewModel() {

    private val _timer = MutableLiveData<Int>()
    val timer: LiveData<Int> = _timer

    private val _isCompleted = MutableLiveData<Boolean>()
    val isCompleted: LiveData<Boolean> = _isCompleted

    init {
        _isCompleted.value = false
    }

    fun subscribeToTimer() {
        repository.getTimer().subscribe({
            Log.d(TEST_TAG, "Next int: $it")
            _timer.value = it
        }, {
            Log.d(TEST_TAG, "Error: $it")
        }, {
            Log.d(TEST_TAG, "Complete!")
            _isCompleted.value = true
        })

    }

}
