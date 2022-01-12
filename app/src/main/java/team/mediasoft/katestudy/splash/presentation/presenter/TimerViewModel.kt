package team.mediasoft.katestudy.splash.presentation.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import team.mediasoft.katestudy.splash.presentation.repository.TimerRepository

class TimerViewModel : ViewModel() {

    private val repository = TimerRepository()

    fun getTimer(): LiveData<Int> {
        return repository.getReactiveTimer()
    }
}
