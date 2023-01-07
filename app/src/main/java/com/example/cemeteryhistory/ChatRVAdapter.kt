package com.example.cemeteryhistory

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class ChatRVAdapter(val messages: ArrayList<Message>)
    : RecyclerView.Adapter<ChatRVAdapter.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        if(messages[position].person == PERSON_USER)
            return 2
        return 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.chat_item_user, parent, false)
        if(viewType == 1){
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.chat_item_game,parent,false);
        }

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = messages[position].text;

        if(messages[position].person != PERSON_USER)
            holder.titleView.text = messages[position].person

    }

    override fun getItemCount(): Int {
        return messages.size;
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.text_massage)
        val titleView: TextView = itemView.findViewById(R.id.card_item_game_title_message)
//        val card: CardView = itemView.findViewById(R.id.chat_card)
    }
}