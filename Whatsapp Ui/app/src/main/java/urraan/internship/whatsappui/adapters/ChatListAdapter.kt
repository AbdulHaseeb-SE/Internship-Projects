package urraan.internship.whatsappui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import urraan.internship.whatsappui.databinding.ChatListItemBinding
import urraan.internship.whatsappui.models.ChatDataClass

class ChatListAdapter(
    private val listChatItems : List<ChatDataClass>
) : RecyclerView.Adapter<ChatListAdapter.ViewHolder>(){
    class ViewHolder(val binding: ChatListItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ChatListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = listChatItems[position]
        holder.binding.textviewContactName.text = currentItem.contactName
        holder.binding.textviewRecentChatMessage.text = currentItem.recentChatMessage
        holder.binding.imageViewContactImage.setImageDrawable(currentItem.contactImage)
        holder.binding.textviewDateTime.text = currentItem.chatDateTime
    }

    override fun getItemCount() = listChatItems.size
}