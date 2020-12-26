package com.example.adaptersconlista

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class StringAdapter(var listaString : MutableList<String>) : RecyclerView.Adapter<StringAdapter.StringViewHolder>()  {

    class StringViewHolder(var root: View, var textView: TextView, var checkBox: CheckBox) : RecyclerView.ViewHolder(root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        val twTextView = view.findViewById<TextView>(R.id.textView)
        val twCheckBox = view.findViewById<CheckBox>(R.id.checkBox)
        return StringViewHolder(view, twTextView, twCheckBox)
    }

    override fun getItemCount(): Int {
        return listaString.size + 1
    }

    override fun onBindViewHolder(holder: StringViewHolder, position: Int) {
        if (position == itemCount -1) {
            holder.textView.text = "Insertar"
            holder.checkBox.setVisibility(View.INVISIBLE)
            holder.root.setOnClickListener {
                val toast = Toast.makeText(it.context, "Añadiendo...", Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER,0,0)
                toast.show()
                listaString.add("Elemento$position")
                notifyDataSetChanged()
            }
            return
        }
        if (position==itemCount-2){
            holder.textView.text = "Contar Encendidos"
            holder.checkBox.setVisibility(View.INVISIBLE)
            holder.root.setOnClickListener {
                var encendidos=0
                for(i in 0..itemCount-1){
                    if(holder.checkBox.isChecked){
                        encendidos+=1
                    }
                }
                val toast = Toast.makeText(it.context, "Hay un total de $encendidos ordenadores encendidos", Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER,0,0)
                toast.show()

            }
            return
        }
        if (position==0){
            holder.textView.text = "Borrar"
            holder.checkBox.setVisibility(View.INVISIBLE)
            holder.root.setOnClickListener {
                var num= Random.nextInt(itemCount-1)
                listaString.remove("Elemento$num")
                notifyDataSetChanged()
            }
            return
        }
        var num=0
        if (position != 0 && position != itemCount-1 && position != itemCount-2) {
            num+=1
            holder.textView.text = "PC-$num"
            var encender= Random.nextBoolean()
            if (encender){
                holder.checkBox.setChecked(true)
            }else{
                holder.checkBox.setChecked(false)
            }
            if(holder.checkBox.isChecked){
                holder.textView.setBackgroundColor(holder.textView.context.getColor(R.color.green))
            }else{
                holder.textView.setBackgroundColor(holder.textView.context.getColor(R.color.red))
            }
        }
        holder.checkBox.setOnClickListener{
            if(holder.checkBox.isChecked){
                holder.textView.setBackgroundColor(holder.textView.context.getColor(R.color.green))
            }else{
                holder.textView.setBackgroundColor(holder.textView.context.getColor(R.color.red))
            }
        }

    }

}