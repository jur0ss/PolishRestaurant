package com.example.polishrestaurant


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.polishrestaurant.databinding.FragmentReadyMealBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ReadyMealFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ReadyMealFragment : Fragment() {

    private val orderViewModel: OrderViewModel by activityViewModels()

    private var _binding: FragmentReadyMealBinding? = null
    private val binding get() = _binding!!

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReadyMealBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        val bottomNav = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNav.selectedItemId = R.id.menuChoiceFragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.soupSpinner.adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            soupsList.map { "${it.name} - ${it.price.toInt()} zł" }
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        binding.mainDishSpinner.adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            mainDishesList.map { "${it.name} - ${it.price.toInt()} zł" }
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        binding.drinkSpinner.adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            drinksList.map { "${it.name} - ${it.price.toInt()} zł" }
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }


        val listener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                v: View?,
                position: Int,
                id: Long
            ) {
                val soup = soupsList[binding.soupSpinner.selectedItemPosition]
                val main = mainDishesList[binding.mainDishSpinner.selectedItemPosition]
                val drink = drinksList[binding.drinkSpinner.selectedItemPosition]

                orderViewModel.setSoup(soup)
                orderViewModel.setMainDish(main)
                orderViewModel.setDrink(drink)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        binding.soupSpinner.onItemSelectedListener = listener
        binding.mainDishSpinner.onItemSelectedListener = listener
        binding.drinkSpinner.onItemSelectedListener = listener


        orderViewModel.currentTotal.observe(viewLifecycleOwner) { total ->
            binding.totalTextView.text = "Cena całkowita: ${total.toInt()} zł"
        }


        binding.placeOrderButton.setOnClickListener {
            orderViewModel.confirmOrder()
            findNavController().navigate(R.id.action_readyMealFragment_to_menuChoiceFragment)
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ReadyMealFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ReadyMealFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}