package com.anelcc.guessexample.screen.game

import android.os.Bundle
import android.text.format.DateUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.anelcc.guessexample.R
import com.anelcc.guessexample.databinding.GameFragmentBinding
import androidx.navigation.fragment.findNavController


public class GameFragment : Fragment() {

    //instance the view model for notify and create a reference
    private lateinit var viewModel: GameViewModel

    private lateinit var binding: GameFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.game_fragment,
            container,
            false
        )

        Log.i("GameFragment", "Called ViewModelProvider.Of")

        // Create a new instance by specific ViewModel: is associate with the ui and the view
        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)

        binding.correctButton.setOnClickListener {
            viewModel.onCorrect()
            updateWordText()
        }
        binding.skipButton.setOnClickListener {
            viewModel.onSkip()
            updateWordText()
        }

        /** Setting up LiveData observation relationship **/
        viewModel.score.observe(this, Observer { newScore ->
            binding.scoreText.text = newScore.toString()
        })

        // You can use DateUtils.formatElapsedTime to correctly format the long to a time string
        viewModel.currentTime.observe(this, Observer { newTime ->
            binding.timerText.text = DateUtils.formatElapsedTime(newTime)
        })

        // Sets up event listening to navigate the player when the game is finished
        viewModel.eventGameFinish.observe(this, Observer {hasFinish ->
            if (hasFinish){
                val currentScore = viewModel.score.value ?: 0
                val action = GameFragmentDirections.actionGameToScore(currentScore)
                findNavController().navigate(action)
                viewModel.onGameFinishComplete()
            }
        })
        return binding.root
    }

    /**
     * Called when the game is finished
     */
    private fun gameFinished() {
        /*val currentScore = viewModel.score.value ?: 0
        val action = GameFragmentDirections.actionGameToScore(currentScore)
        findNavController().navigate(action)*/
        Toast.makeText(this.activity, "Game has finished", Toast.LENGTH_SHORT).show()
    }

    /** Methods for updating the UI **/

    private fun updateWordText() {
        binding.wordText.text = viewModel.word.value
    }
}