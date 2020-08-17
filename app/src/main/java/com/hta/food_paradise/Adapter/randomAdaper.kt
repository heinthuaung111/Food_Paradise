package com.hta.food_paradise.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hta.food_paradise.Model.Categories.Category
import com.hta.food_paradise.Model.Meal
import com.hta.food_paradise.Model.Random
import com.hta.food_paradise.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_random.view.*

class randomAdaper(var meal:List<Meal> =ArrayList<Meal>()):RecyclerView.Adapter<randomAdaper.randomViewHolder>() {

    inner class randomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(obj: Meal){
            itemView.r_txtview.text=obj.strCategory
            Picasso.get().load(obj.strMealThumb).into(itemView.random_image)
        }
    }

    fun updateRandom(result: List<Meal>) {
        this.meal = result
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): randomViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.item_random,parent,false)
        return randomViewHolder(view)
    }

    override fun getItemCount(): Int {
    return meal.size
    }

    override fun onBindViewHolder(holder: randomViewHolder, position: Int) {
    holder.bind(meal[position])
    }


}