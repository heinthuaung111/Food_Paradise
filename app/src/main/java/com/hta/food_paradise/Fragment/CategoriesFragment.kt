package com.hta.food_paradise.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.hta.food_paradise.Adapter.categoriesAdapter
import com.hta.food_paradise.R
import com.hta.food_paradise.ViewModel.CategoriesViewModel
import kotlinx.android.synthetic.main.fragment_categories.*


class CategoriesFragment : Fragment() {

    private lateinit var categoriesviewmodel:CategoriesViewModel
    private lateinit var categoriesadapter:categoriesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoriesviewmodel=ViewModelProvider(this).get(CategoriesViewModel::class.java)
        categoriesadapter= categoriesAdapter()
        c_recyclerview.apply {
            layoutManager=GridLayoutManager(context,3)
            adapter=categoriesadapter
        }
        observeViewmodel()


    }
    private fun observeViewmodel(){
        categoriesviewmodel.getResult().observe(viewLifecycleOwner, Observer { categories ->
            categoriesadapter.updateArticle(categories.categories)
        })
    }

    override fun onResume() {
        super.onResume()
        categoriesviewmodel.loadResult()
    }

}
