package team.mediasoft.katestudy.baseapp.utils

import android.util.Log

private const val DEBUG_TAG = "DEBUG_EVENT"
private const val ERROR_TAG = "ERROR_OCCURRED"

fun debugLog(msg: String) {
    Log.d(DEBUG_TAG, "[$msg]")
}

fun errorLog(error: Throwable, errorMessage: String? = null) {
    val msg = errorMessage ?: error.localizedMessage
    Log.e(ERROR_TAG, "[$msg]")
}