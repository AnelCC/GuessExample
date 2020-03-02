package com.anelcc.guessexample.screen.game

import android.util.Log
import androidx.lifecycle.ViewModel
//The ViewModel is a stable place to store the data to display in the associated UI controller.
//The Fragment draws the data on screen and captures input events. It should not decide what to display on screen or process what happens during an input event.
//The ViewModel never contains references to activities, fragments, or views.
class GameViewModel : ViewModel(){
    init {
        Log.i("GameViewModel", "GameViewModel created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }
}