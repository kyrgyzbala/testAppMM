package kg.kyrgyzcoder.enter_fr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import kg.kyrgyzcoder.display_fr.ViewModelD
import kg.kyrgyzcoder.enter_fr.databinding.FragmentEnterBinding


class EnterFragment : Fragment() {

    private var _binding: FragmentEnterBinding? = null
    private val binding get() = _binding!!

    private var value: Int = 0

    private val viewModel: ViewModelD by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEnterBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.plusButton.setOnClickListener {
            handlePlusClick()
        }

        binding.minusButton.setOnClickListener {
            handleMinusClick()
        }
    }

    private fun handleMinusClick() {
        if (value > 0) {
            value -= 10
            binding.amountTextView.text = value.toString()
            viewModel.changeValue(value)
            if (value == 0)
                disableMinus()
            if (value != 100)
                enablePlus()
        }
    }

    private fun handlePlusClick() {
        if (value < 100) {
            value += 10
            binding.amountTextView.text = value.toString()
            viewModel.changeValue(value)
            if (value == 100)
                disablePlus()
            if (value > 0)
                enableMinus()
        }
    }

    private fun enableMinus() {
        binding.minusButton.background =
            ContextCompat.getDrawable(requireContext(), R.drawable.back_button_active)
    }

    private fun disableMinus() {
        binding.minusButton.background =
            ContextCompat.getDrawable(requireContext(), R.drawable.back_button_inactive)
    }

    private fun enablePlus() {
        binding.plusButton.background =
            ContextCompat.getDrawable(requireContext(), R.drawable.back_button_active)
    }

    private fun disablePlus() {
        binding.plusButton.background =
            ContextCompat.getDrawable(requireContext(), R.drawable.back_button_inactive)
    }

}