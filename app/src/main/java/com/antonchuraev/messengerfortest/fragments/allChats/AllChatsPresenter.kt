package com.antonchuraev.messengerfortest.fragments.allChats

import android.util.Log
import com.antonchuraev.messengerfortest.base.BasePresenter
import com.antonchuraev.messengerfortest.dataClasses.chats.ChatPreview
import moxy.InjectViewState

@InjectViewState
class AllChatsPresenter: BasePresenter<AllChatsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        Log.d( tag , "onFirstViewAttach() called")
    }



    fun loadChatsPreview():List<ChatPreview>{
        TODO( "Загрузка сообщений для главного экрана")
    }

    fun generateTestChatsPreview(){
        logState("generateTestChatsPreview")

        val  testMessage = mutableListOf<ChatPreview>().apply {
            addAll( ChatPreview.generateRandomList() )
        }
        viewState.setChats( testMessage )
    }

    fun loadChat(messagePreview: ChatPreview) {
        logState("onMessagesPreviewClick")

        // TODO: 14.04.2021 метод получения чата

        viewState.openChat(messagePreview)
    }

}