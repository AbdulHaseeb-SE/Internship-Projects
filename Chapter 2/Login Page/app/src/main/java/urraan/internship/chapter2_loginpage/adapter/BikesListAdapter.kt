package urraan.internship.chapter2_loginpage.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import androidx.recyclerview.widget.RecyclerView
import urraan.internship.chapter2_loginpage.UpdateBikeDetails
import urraan.internship.chapter2_loginpage.databinding.RecyclerviewitemsBinding
import urraan.internship.chapter2_loginpage.entity.Bike

class BikesListAdapter(
    val context: Context,
    val deleteOnLongClick: (Bike) -> Unit
): RecyclerView.Adapter<BikesListAdapter.ViewHolder>(){
    class ViewHolder(val binding: RecyclerviewitemsBinding):RecyclerView.ViewHolder(binding.root)
    private var data: List<Bike> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RecyclerviewitemsBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = data[position]

        holder.binding.textviewModelNo.text = buildSpannedString {
            bold { append("Model No. ") }
            append(currentItem.model_No)
        }
        holder.binding.textviewCompanyName.text = currentItem.company
        holder.binding.textviewEngineCapacity.text = buildSpannedString {
            bold { append("Engine : ") }
            append(currentItem.engine_capacity)
            append(" cc")
        }
        holder.binding.textviewPrice.text = buildSpannedString {
            bold { append("Price : ")}
            append(currentItem.price.toString())
        }

        holder.binding.cardviewMainLayoutItems.setOnClickListener {
            val intent =  Intent(context, UpdateBikeDetails::class.java)
            intent.putExtra("modelNo", currentItem.model_No)
            intent.putExtra("company", currentItem.company)
            intent.putExtra("Engine", currentItem.engine_capacity)
            intent.putExtra("price", currentItem.price.toString())
            context.startActivity(intent)
        }

        holder.binding.cardviewMainLayoutItems.setOnLongClickListener {
            deleteOnLongClick(currentItem)
            true
        }
    }

    override fun getItemCount() = data.size

    fun SetData(list: List<Bike>){
        data = list
        notifyDataSetChanged()
    }


}