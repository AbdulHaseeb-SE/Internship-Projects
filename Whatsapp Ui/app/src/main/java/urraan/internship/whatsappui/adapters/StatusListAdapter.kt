package urraan.internship.whatsappui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import urraan.internship.whatsappui.databinding.StatusListItemBinding
import urraan.internship.whatsappui.models.StatusDataClass

class StatusListAdapter(
    val listStatusItems: List<StatusDataClass>
) : RecyclerView.Adapter<StatusListAdapter.ViewHolder>() {
    class ViewHolder(
        val binding: StatusListItemBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        StatusListItemBinding.inflate(
            LayoutInflater.from(
                parent.context
            ),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentPosition = listStatusItems[position]
        holder.binding.imageViewStatusThumbnail.setImageDrawable(currentPosition.statusThumbnail)
        holder.binding.textViewStatusPersonName.text = currentPosition.statusPersonName
        holder.binding.textViewStatusTime.text = currentPosition.statusTime
    }

    override fun getItemCount(): Int = listStatusItems.size
}