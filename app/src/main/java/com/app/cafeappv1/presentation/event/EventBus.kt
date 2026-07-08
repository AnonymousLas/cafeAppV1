package com.app.cafeappv1.presentation.event

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

object EventBus {
    private val _events = MutableSharedFlow<UIEvent>(extraBufferCapacity = 1)
    val events = _events.asSharedFlow()

    suspend fun send(event: UIEvent){
        _events.emit(event)
    }

}