package com.example.cemeteryhistory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var rvChat: RecyclerView;
    private lateinit var messages: MutableLiveData<ArrayList<Message>>;
    val history = History()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvChat = findViewById<RecyclerView>(R.id.rv_chat);
        val button = findViewById<Button>(R.id.button_send)
        val editText = findViewById<EditText>(R.id.edit_answer)

        messages = MutableLiveData();
        messages.postValue(ArrayList<Message>())
        messages.observe(this){
            updateRvChatAdapter(it)
            rvChat.scrollToPosition(it.size-1)
        }


        button.setOnClickListener(View.OnClickListener {
            buttonClick(editText.text.toString())
            editText.setText("")
        })

        addMessages(history.hi())

    }


    private fun buttonClick(userAnswer: String) {
        val userInput = UserInput();
        val answer = userInput.userAnswer(userAnswer)
        messages.value!!.add(Message(answer, PERSON_USER))

        addMessages((ArrayList<Message>( history.menu(answer))))
    }

    private fun updateRvChatAdapter(messages: ArrayList<Message>) {
        rvChat.adapter = ChatRVAdapter(messages)

    }

    private fun addMessages(arrayMessage: ArrayList<Message>) {
        CoroutineScope(Dispatchers.Default).launch {
        for (message in arrayMessage) {
            addMessage(message)
        }
        }
    }

    operator fun <T> MutableLiveData<ArrayList<Message>>.plusAssign(item: T){
        val value = this.value ?: emptyList()
    }

//    private fun addMessages(message: Message) {
//        runBlocking {
//            launch {
//                addMessages(message)
//            }
//        }
//    }



    suspend fun addMessage(message: Message){
        if(message.type == IMAGE) {
            delay(200L)
        }else{
            delay(message.text.length * 45L)
//            delay(message.text.length * 1L)
        }
//        messages.plusAssign(message)
        messages.value!!.add(message)
        messages.postValue(messages.value)
//        updateRvChatAdapter()
    }

}
