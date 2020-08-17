package com.hta.food_paradise.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hta.food_paradise.Model.Categories.CategoriesModel
import com.hta.food_paradise.Model.Categories.Category
import com.hta.food_paradise.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_categories.view.*

class categoriesAdapter(var categorylist:List<Category> =ArrayList<Category>()):RecyclerView.Adapter<categoriesAdapter.categoriesViewHolder>() {

inner class categoriesViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    fun bind(obj:Category){
        itemView.ctxtview.text=obj.strCategory
        Picasso.get().load(obj.strCategoryThumb).into(itemView.c_image)
    }
}

    fun updateArticle(result: List<Category>) {
        this.categorylist = result
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): categoriesViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_categories,parent,false)
        return categoriesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categorylist.size
    }

    override fun onBindViewHolder(holder: categoriesViewHolder, position: Int) {
        holder.bind(categorylist[position])
    }
}