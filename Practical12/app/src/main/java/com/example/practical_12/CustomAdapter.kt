package com.example.practical_12

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView

class CustomAdapter (context: Context,arrayListDetails:ArrayList<Model>) : BaseAdapter(){

    private val layoutInflater: LayoutInflater
    private val arrayListDetails:ArrayList<Model>

    init {
        this.layoutInflater = LayoutInflater.from(context)
        this.arrayListDetails=arrayListDetails
    }

    override fun getCount(): Int {
        return arrayListDetails.size
    }

    override fun getItem(position: Int): Any {
        return arrayListDetails.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val view: View?
        val listRowHolder: ListRowHolder
        if (convertView == null) {
            view = this.layoutInflater.inflate(R.layout.adapter_layout, parent, false)
            listRowHolder = ListRowHolder(view)
            view.tag = listRowHolder

        } else {
            view = convertView
            listRowHolder = view.tag as ListRowHolder
        }


        listRowHolder.tvId.text = arrayListDetails.get(position).id
        listRowHolder.tvFname.text = arrayListDetails.get(position).First_name
        listRowHolder.tvLname.text = arrayListDetails.get(position).Last_name
        listRowHolder.tvPhone.text = arrayListDetails.get(position).phone_no
        listRowHolder.tvAddress.text = arrayListDetails.get(position).address

        return view
    }
}

private class ListRowHolder(row: View?) {
    public val tvId: TextView
    public val tvFname: TextView
    public val tvLname: TextView
    public val tvPhone: TextView
    public val tvAddress: TextView

    public val linearLayout: LinearLayout

    init {
        this.tvId = row?.findViewById<TextView>(R.id.id) as TextView
        this.tvFname = row.findViewById<TextView>(R.id.fname) as TextView
        this.tvLname = row.findViewById<TextView>(R.id.lname) as TextView
        this.tvPhone = row.findViewById<TextView>(R.id.phone) as TextView
        this.tvAddress = row.findViewById<TextView>(R.id.address) as TextView

        this.linearLayout = row.findViewById<LinearLayout>(R.id.linearLayout) as LinearLayout
    }
}

