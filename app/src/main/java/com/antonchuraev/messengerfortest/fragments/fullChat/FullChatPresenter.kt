package com.antonchuraev.messengerfortest.fragments.fullChat

import com.antonchuraev.messengerfortest.base.BasePresenter
import com.antonchuraev.messengerfortest.dataClasses.chats.Chat
import com.antonchuraev.messengerfortest.dataClasses.messages.Message
import moxy.InjectViewState

@InjectViewState
class FullChatPresenter: BasePresenter<FullChatView>() {





    fun loadChat():Chat{
        TODO( "Загрузка сообщений для главного экрана")
    }

    fun generateTestChat(){
        logState("generateTestMessagesPreview")


        viewState.setChat( Chat.generateRandomChat() )
    }

    fun selectMessage(message: Message) {
        logState("onMessagesPreviewClick")


        viewState.messageSelected( message)
    }

}