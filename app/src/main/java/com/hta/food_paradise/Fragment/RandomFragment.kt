package com.hta.food_paradise.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.hta.food_paradise.Adapter.randomAdaper

import com.hta.food_paradise.R
import com.hta.food_paradise.ViewModel.RandomViewModel
import kotlinx.android.synthetic.main.fragment_random.*


class RandomFragment : Fragment() {

    lateinit var randomviewmodel: RandomViewModel
    private lateinit var randomadapter: randomAdaper


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_random, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        randomviewmodel = ViewModelProvider(this).get(RandomViewModel::class.java)
        randomadapter = randomAdaper()

        recyclerview.apply {
            layoutManager=LinearLayoutManager(context)
            adapter=randomadapter
        }

        observeViewmodel()
    }
    private fun observeViewmodel(){
        randomviewmodel.getResult().observe(viewLifecycleOwner, Observer { random ->
            randomadapter.updateRandom(random.meals)
        })
    }

    override fun onResume() {
        super.onResume()
        randomviewmodel.loadResult()
    }
}

