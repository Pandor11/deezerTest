package com.example.gradlekotlintest.presentation.decorations

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class PlaylistDecorator(
    private val viewType: Int,
    private val outerDivider: Int,
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        if (parent.getChildViewHolder(view).itemViewType != viewType) return

        val adapter = parent.adapter ?: return
        val currentPosition =
            parent.getChildAdapterPosition(view).takeIf { it != RecyclerView.NO_POSITION } ?: return

        val isPrevTargetView = adapter.isFirst(currentPosition, viewType)
        val isDividedByThreeReverse = adapter.isDividedByThreeReverse(currentPosition, viewType)
        val isDividedByThree = adapter.isDividedByThree(currentPosition, viewType)

        val centerInnerDivider = outerDivider / 2

        with(outRect) {
            top = centerInnerDivider
            bottom = 0
            left = if (isPrevTargetView || isDividedByThree) outerDivider
            else if (!isDividedByThreeReverse) centerInnerDivider
            else 0
            right = if (isDividedByThreeReverse) outerDivider
            else if (isPrevTargetView || isDividedByThree) 0
            else centerInnerDivider
        }
    }

    private fun RecyclerView.Adapter<*>.isFirst(
        currentPosition: Int,
        viewType: Int
    ) = currentPosition == 0 && getItemViewType(currentPosition - 1) == viewType

    private fun RecyclerView.Adapter<*>.isDividedByThreeReverse(
        currentPosition: Int,
        viewType: Int
    ) = (currentPosition + 1) % 3 == 0 && getItemViewType(currentPosition - 1) == viewType

    private fun RecyclerView.Adapter<*>.isDividedByThree(
        currentPosition: Int,
        viewType: Int
    ) = (currentPosition) % 3 == 0 && getItemViewType(currentPosition - 1) == viewType

}