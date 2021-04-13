package com.antonchuraev.messengerfortest.fragments.fullChat

import android.annotation.SuppressLint
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.marginTop
import androidx.core.view.setPadding
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.antonchuraev.messengerfortest.R
import com.antonchuraev.messengerfortest.base.BaseFragment
import com.antonchuraev.messengerfortest.dataClasses.chats.Chat
import com.antonchuraev.messengerfortest.dataClasses.chats.ChatPreview
import com.antonchuraev.messengerfortest.dataClasses.messages.Message
import com.antonchuraev.messengerfortest.databinding.FragmentAllMessagesBinding
import com.antonchuraev.messengerfortest.helpers.adapter.AllChatsRecyclerAdapter
import com.antonchuraev.messengerfortest.helpers.adapter.AllMessagesRecyclerAdapter
import com.antonchuraev.messengerfortest.helpers.adapter.DataHandler
import com.antonchuraev.messengerfortest.helpers.extensions.toast
import moxy.presenter.InjectPresenter


class FullChatFragment : BaseFragment<FragmentAllMessagesBinding>() , FullChatView {

    @InjectPresenter
    lateinit var presenter: FullChatPresenter

    override val layoutView: Int = R.layout.fragment_all_messages

    private var recyclerAdapter:AllMessagesRecyclerAdapter = AllMessagesRecyclerAdapter() // TODO: 14.04.2021

    override fun onCreateView(rootView: View) {
        setRecyclerAdapter()
        setListeners()

    }

    private fun setRecyclerAdapter() {
        context?.let { context->

            binding.allMessagesRecycler.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = recyclerAdapter
            }

        }

        presenter.generateTestChat()
    }

    private fun setListeners() {

        recyclerAdapter.apply {
            listener = object : DataHandler<Message>{
                override fun invoke(model: Message) {
                    presenter.selectMessage(model)
                }
            }
        }

    }


    override fun setChat(chat: Chat) {
        recyclerAdapter.items = chat.messages
    }

    override fun messageSelected(message: Message) {
        context?.toast( message.toString() )


    }

    companion object {
        fun newInstance() = FullChatFragment()
    }

}