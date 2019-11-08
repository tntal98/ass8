package com.example.assignment8

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.emp_item_layout.view.*

class EmployeeAdapter (val item : List<Employee>, val context: Context): RecyclerView.Adapter<ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName?.text= "Name: "+item[position].emp_name
        holder.tvGender?.text="Gender: "+ item[position].emp_gender
        holder.tvEmail?.text="E-mail: "+ item[position].emp_email
        holder.tvSalary?.text="Salary: "+ item[position].emp_salary

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view_item = LayoutInflater.from(parent.context).inflate(R.layout.emp_item_layout,parent,false)
        return ViewHolder(view_item )

    }

    override fun getItemCount(): Int {
        return item.size
    }

}


class ViewHolder (view: View): RecyclerView.ViewHolder(view){
    val tvName = view.tv_Name
    val tvGender = view.tv_Gender
    val tvEmail = view.tv_Email
    val tvSalary = view.tv_Salary
}
