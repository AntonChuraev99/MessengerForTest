package com.antonchuraev.messengerfortest.fragments.allChats

import com.antonchuraev.messengerfortest.dataClasses.chats.ChatPreview
import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

interface AllChatsView: MvpView {

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun setChats(messages: List<ChatPreview>)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun openChat(messagePreview: ChatPreview)

}