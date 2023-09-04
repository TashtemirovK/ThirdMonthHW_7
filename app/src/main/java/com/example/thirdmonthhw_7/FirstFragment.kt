package com.example.thirdmonthhw_7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.thirdmonthhw_7.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var personList: ArrayList<Persons>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()

        val adapter = PersonAdapter(personList,this::onItemClick)
        binding.rvView.adapter = adapter
    }



    private fun loadData() {
        personList = ArrayList()

        personList.apply {
            add(Persons("Rick Sanchez","Alive",R.drawable._image_rickky))
            add(Persons("Morti Smith","Alive",R.drawable._image_morti))
            add(Persons("Albert Einstein","Dead",R.drawable._image_professor))
            add(Persons("Jerry Smith","Alive",R.drawable._image_levyi_chel))
        }
    }

    private fun onItemClick(persons: Persons) {
        val bundle = Bundle()
        bundle.putSerializable("key",persons)
        findNavController().navigate(R.id.secondFragment,bundle)
    }

}