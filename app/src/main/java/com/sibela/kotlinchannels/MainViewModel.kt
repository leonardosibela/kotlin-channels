package com.sibela.kotlinchannels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val eventChannel = Channel<Event>()
    val eventFlow = eventChannel.receiveAsFlow()

    fun triggerEvent() = viewModelScope.launch {
        eventChannel.send(Event.ErrorEvent("This is an error"))
    }

    sealed class Event {
        data class ErrorEvent(val message: String) : Event()
    }

}