package com.mek.todoapplication.utilities

import android.content.res.ColorStateList
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mek.todoapplication.R
import com.mek.todoapplication.model.Priority
import com.mek.todoapplication.model.ToDoModel
import com.mek.todoapplication.ui.home.HomeListAdapter
import com.mek.todoapplication.ui.home.ToDoClickListener


@BindingAdapter("setItemToDoPriorityTint")
fun setItemToDoPriorityTint(imageView : ImageView,priority: Priority){
    val context = imageView.context

    val color = when(priority){
        Priority.HIGH -> R.color.priority_high
        Priority.MEDIUM -> R.color.md_theme_light_secondary
        else -> R.color.seed
    }

    ImageViewCompat.setImageTintList(imageView, ColorStateList.valueOf(ContextCompat.getColor(context,color)))
}

@BindingAdapter("toDoList","setOnClickListener")
fun setHomeRecyclerViewAdapter(
    recyclerView : RecyclerView,
    list : List<ToDoModel>?,
    toDoClickListener : ToDoClickListener
){
    recyclerView.apply {
        if (this.adapter == null){
            adapter = HomeListAdapter(toDoClickListener).apply { submitList(list) }
        }else{
            (this.adapter as HomeListAdapter).submitList(list)
        }
    }
}