package com.example.datakaryawan.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.datakaryawan.Model.Employe
import com.example.datakaryawan.R

class EmployeAdapter (val context: Context): RecyclerView.Adapter<EmployeAdapter.EmployeViewHolder>(){

    private var employees : MutableList<Employe> = mutableListOf()
    inner class EmployeViewHolder (i : View):RecyclerView.ViewHolder(i){
        val tvId: TextView = i.findViewById(R.id.tv_id)
        val tvNamaKaryawan: TextView = i.findViewById(R.id.tv_namaKaryawan)
        val tvNip: TextView = i.findViewById(R.id.tv_Nip)
        val tvJabatan: TextView = i.findViewById(R.id.tv_Jabatan)
        val tvEmail: TextView = i.findViewById(R.id.tv_Email)
        fun bindModel(u : Employe){
            tvId.text=u.getId().toString()
            tvNamaKaryawan.text=u.getNamaKaryawan()
            tvNip.text=u.getNip()
            tvJabatan.text=u.getJabatan()
            tvEmail.text=u.getEmail()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeViewHolder {
        return EmployeViewHolder(LayoutInflater.from(context).inflate(R.layout.item_employe, parent, false))
    }

    override fun getItemCount(): Int {
        return employees.size
    }

    override fun onBindViewHolder(holder: EmployeViewHolder, position: Int) {
        holder.bindModel(employees[position])
    }

    fun setEmploye(data: List<Employe>){
        employees.clear()
        employees.addAll(data)
        notifyDataSetChanged()
    }
}