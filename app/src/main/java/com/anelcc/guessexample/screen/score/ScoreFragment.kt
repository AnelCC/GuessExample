package com.anelcc.guessexample.screen.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import com.anelcc.guessexample.R
import com.anelcc.guessexample.databinding.ScoreFragmentBinding
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs


class ScoreFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate view and obtain an instance of the binding class.
        val binding: ScoreFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.score_fragment,
            container,
            false
        )

        // Get args using by navArgs property delegate
   /*     val scoreFragmentArgs by navArgs<ScoreFragmentArgs>()
        binding.scoreText.text = scoreFragmentArgs.score.toString()
        binding.playAgainButton.setOnClickListener { onPlayAgain() }*/

        return binding.root
    }

    private fun onPlayAgain() {
        //findNavController().navigate(ScoreFragmentDirections.actionRestart())
    }
}