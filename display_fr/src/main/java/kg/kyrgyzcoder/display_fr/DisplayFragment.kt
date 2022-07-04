package kg.kyrgyzcoder.display_fr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import kg.kyrgyzcoder.display_fr.databinding.FragmentDisplayBinding


class DisplayFragment : Fragment() {

    private var _binding: FragmentDisplayBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ViewModelD by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDisplayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.value.observe(viewLifecycleOwner) { value ->
            val str = "$value %"
            binding.percentageTextView.text = str
            val pr = viewModel.getBitmapProgress(value)
            binding.progressImageView.setImageBitmap(pr)
        }
    }

}