package com.hta.food_paradise.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import com.hta.food_paradise.R
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_first_letter.*


class FirstLetterFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first_letter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var character= arrayOf("A","B")
//        var arrayAdapter=ArrayAdapter(this,android.R.layout.simple_spinner_item, character)

//        sp.adapter=arrayAdapter
        sp.onItemSelectedListener=object:

            AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                tv1.text=character[p2]
            }

        }
    }
}