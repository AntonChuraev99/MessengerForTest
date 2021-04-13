package com.antonchuraev.messengerfortest.fragments.fullChat

import com.antonchuraev.messengerfortest.dataClasses.chats.Chat
import com.antonchuraev.messengerfortest.dataClasses.chats.ChatPreview
import com.antonchuraev.messengerfortest.dataClasses.messages.Message
import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface FullChatView: MvpView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun setChat(chat: Chat)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun messageSelected(message: Message)

}