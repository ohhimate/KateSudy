package team.mediasoft.katestudy.baseapp.presentation.viewmodel

import androidx.lifecycle.ViewModel

abstract class BaseViewModel: ViewModel() {
    abstract fun onBind()
}