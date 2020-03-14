package com.anelcc.guessexample.screen.score

import android.util.Log
import androidx.lifecycle.ViewModel

class ScoreViewModel (finalScore: Int) : ViewModel() {
    init {
        Log.i("ScoreViewModel", "Final Score in $finalScore")
    }
}