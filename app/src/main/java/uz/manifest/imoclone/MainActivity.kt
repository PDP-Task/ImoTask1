package uz.manifest.imoclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.manifest.imoclone.adapter.ChatAdapter
import uz.manifest.imoclone.model.Chat

class MainActivity : AppCompatActivity() {
    private val chats: ArrayList<Chat> = ArrayList()
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView.layoutManager = GridLayoutManager(this, 1)

        refreshAdapter(getAllChats())
    }

    private fun refreshAdapter(chats: ArrayList<Chat>) {
        val adapter = ChatAdapter(this, chats)
        recyclerView.adapter = adapter
    }

    private fun getAllChats(): ArrayList<Chat> {
        for (i in 0..30) {
            when {
                i % 3 == 0 -> {
                    chats.add(Chat(R.drawable.img_android, "Android", 1, true))
                }
                i % 4 == 0 -> {
                    chats.add(Chat(R.drawable.kotlin_img, "Kotlin", 0, false))
                }
                else -> {
                    chats.add(Chat(R.drawable.java, "Java", 2, true))
                }
            }
        }
        return chats
    }
}