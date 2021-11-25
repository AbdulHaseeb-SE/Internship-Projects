package urraan.internship.whatsappui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import urraan.internship.whatsappui.databinding.CallsListItemBinding
import urraan.internship.whatsappui.models.CallTypes
import urraan.internship.whatsappui.models.CallsDataClass

class CallListAdapter(
    val listCallItems: List<CallsDataClass>
) : RecyclerView.Adapter<CallListAdapter.ViewHolder>() {
    class ViewHolder(
        val binding: CallsListItemBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        CallsListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = listCallItems[position]

        holder.binding.imageViewCallPerson.setImageDrawable(currentItem.callerImage)
        holder.binding.textViewCallTime.text = currentItem.callTime
        holder.binding.textViewCallerName.text = currentItem.callerName

        if(currentItem.callTypeImage == CallTypes.MISSED_CALL){
            holder.binding.imageViewCallType.apply {
                rotation = 130f
            }
        }

    }

    override fun getItemCount(): Int = listCallItems.size
}