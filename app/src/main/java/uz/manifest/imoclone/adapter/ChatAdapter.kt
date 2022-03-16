package uz.manifest.imoclone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.manifest.imoclone.R
import uz.manifest.imoclone.model.Chat
import uz.manifest.imoclone.util.Time

class ChatAdapter(context: Context, private val items: ArrayList<Chat>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_chat_layout, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chat = items[position]

        if (holder is MessageViewHolder) {
            val ivProfile = holder.profileImg
            val tvFullName = holder.tvFullName
            val tvCount = holder.tvCount

            ivProfile.setImageResource(chat.profile)
            tvFullName.text = chat.fullName
            tvCount.text = chat.count.toString()


            if (chat.isOnline) {
                tvCount.setBackgroundResource(R.drawable.shape_circle_green)
            }

            if (chat.count > 0) {
                tvCount.visibility = View.VISIBLE
            } else {
                tvCount.visibility = View.GONE
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val profileImg: ImageView = view.findViewById(R.id.iv_profile)
        val tvFullName: TextView = view.findViewById(R.id.tv_full_name)
        val tvCount: TextView = view.findViewById(R.id.tv_count)
        private val tvTime: TextView = view.findViewById(R.id.tv_time)

        init {
            tvTime.text = Time.timeStamp()
        }
    }
}