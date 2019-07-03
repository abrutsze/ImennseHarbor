package com.testingapp.immenseharbor.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.testingapp.immenseharbor.R
import com.testingapp.immenseharbor.data.models.Department

class DepartmentAdapter (private val results: List<Department>, private val callback: CallBack) : RecyclerView.Adapter<DepartmentAdapter.ViewHolder>() {

    private var mList = ArrayList<Department>()

    init {
        this.mList = results as java.util.ArrayList<Department>
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v  = LayoutInflater.from(viewGroup.context).
            inflate(R.layout.item_department,viewGroup,false);
        return ViewHolder(v)
    }


    override fun getItemCount(): Int = mList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.departmentId.text = mList[0].id.toString()
        holder.departmentName.text = mList[0].departmentName

        holder.itemView.setOnClickListener {
            callback.onItemListener(mList[position])
        }


    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var departmentId: TextView = itemView.findViewById(R.id.departmentId)
        var departmentName: TextView = itemView.findViewById(R.id.departmentName)

    }

    interface CallBack{

        fun onItemListener(department: Department )
    }

}