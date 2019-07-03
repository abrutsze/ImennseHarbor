package com.testingapp.immenseharbor.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.testingapp.immenseharbor.R
import com.testingapp.immenseharbor.data.models.Employee

class EmployeeAdapter (private val results: List<Employee?>?) : RecyclerView.Adapter<EmployeeAdapter.ViewHolder>() {

    private var mList = ArrayList<Employee>()

    init {
        this.mList = results as java.util.ArrayList<Employee>
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v  = LayoutInflater.from(viewGroup.context).
            inflate(R.layout.item_employee,viewGroup,false);
        return ViewHolder(v)
    }


    override fun getItemCount(): Int = mList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (mList[position]!=null){
            holder.name.text = "${mList[position].firstName}  ${mList[position].lastName}"
            holder.email.text = mList[position].email
            holder.phone.text = mList[position].phoneNumber.toString()
            holder.salary.text = mList[position].salary.toString()
        }

    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.name)
        var email: TextView = itemView.findViewById(R.id.email)
        var phone: TextView = itemView.findViewById(R.id.phone)
        var salary: TextView = itemView.findViewById(R.id.salary)

    }



}