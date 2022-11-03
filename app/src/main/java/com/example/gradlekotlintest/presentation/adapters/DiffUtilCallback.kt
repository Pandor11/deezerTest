package com.example.gradlekotlintest.presentation.adapters

import android.util.Log
import androidx.recyclerview.widget.DiffUtil

class DiffUtilCallback<T : IRecyclerItemViewModel> : DiffUtil.Callback() {

    private val oldItems: MutableList<T> = ArrayList()
    private val newItems: MutableList<T> = ArrayList()

    fun update(new: List<T>) = apply {
        oldItems.clear()
        oldItems.addAll(newItems)

        newItems.clear()
        newItems.addAll(new)
        Log.e("DEV12", "${javaClass.simpleName} NEW : $newItems")
        Log.e("DEV12", "${javaClass.simpleName} OLD: $oldItems")
    }

    override fun getOldListSize() = oldItems.size


    override fun getNewListSize() = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        Log.e(
            "DEV11",
            "${javaClass.simpleName} $oldItemPosition $newItemPosition : ITEMS ${oldItems[oldItemPosition].id == newItems[newItemPosition].id}"
        )
        return oldItems[oldItemPosition].id == newItems[newItemPosition].id
    }


    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        Log.e(
            "DEV11",
            "${javaClass.simpleName} $oldItemPosition $newItemPosition : CONTENT ${oldItems[oldItemPosition] == newItems[newItemPosition]}"
        )
        return oldItems[oldItemPosition] == newItems[newItemPosition]
    }
}