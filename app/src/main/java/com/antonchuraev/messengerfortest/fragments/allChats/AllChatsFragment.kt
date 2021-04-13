package com.antonchuraev.messengerfortest.fragments.allChats

import android.annotation.SuppressLint
import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.antonchuraev.messengerfortest.R
import com.antonchuraev.messengerfortest.base.BaseFragment
import com.antonchuraev.messengerfortest.base.Screens
import com.antonchuraev.messengerfortest.dataClasses.chats.ChatPreview
import com.antonchuraev.messengerfortest.databinding.FragmentAllMessagesBinding
import com.antonchuraev.messengerfortest.helpers.adapter.AllChatsRecyclerAdapter
import com.antonchuraev.messengerfortest.helpers.adapter.DataHandler
import com.antonchuraev.messengerfortest.helpers.extensions.toast
import moxy.presenter.InjectPresenter


class AllChatsFragment : BaseFragment<FragmentAllMessagesBinding>() , AllChatsView {

    @InjectPresenter
    lateinit var presenter: AllChatsPresenter

    override val layoutView: Int = R.layout.fragment_all_messages

    private var recyclerAdapter:AllChatsRecyclerAdapter = AllChatsRecyclerAdapter()

    override fun onCreateView(rootView: View) {
        setRecyclerAdapter()
        setListeners()


    }

    private fun setRecyclerAdapter() {
        context?.let { context->

            binding.allMessagesRecycler.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = recyclerAdapter
                addItemDecoration( DividerItemDecoration(context , RecyclerView.VERTICAL).apply {
                    ResourcesCompat.getDrawable(resources , R.drawable.shape_gray ,null)
                            ?.let { setDrawable(it) }
                } )
            }

        }

        presenter.generateTestChatsPreview()
    }

    private fun setListeners() {

        recyclerAdapter.apply {
            listener = object : DataHandler<ChatPreview>{
                override fun invoke(model: ChatPreview) {
                    presenter.loadChat(model)
                }
            }
        }

    }




    @SuppressLint("ResourceAsColor")
    override fun setChats(messages: List<ChatPreview>) {
        recyclerAdapter.items = messages
    }

    override fun openChat(messagePreview: ChatPreview) {
        appRouter.navigateTo( Screens.Screen.FullChat() )
    }

    companion object {
        fun newInstance() = AllChatsFragment()
    }

}