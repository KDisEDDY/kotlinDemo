package project.ljy.kotlindemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import project.ljy.kotlindemo.R
import project.ljy.kotlindemo.base.BaseRecyclerViewAdapter

class GridAdapter(val context: Context, var list: MutableList<String>) : BaseRecyclerViewAdapter<GridAdapter.ViewHolder, String>(context, list) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(context).inflate(R.layout.layout_grid_item, parent, false))

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }
}