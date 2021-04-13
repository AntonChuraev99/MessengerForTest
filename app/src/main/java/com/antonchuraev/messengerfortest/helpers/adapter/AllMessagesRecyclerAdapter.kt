package com.antonchuraev.messengerfortest.helpers.adapter

import android.content.Context
import com.antonchuraev.messengerfortest.dataClasses.chats.ChatPreview
import com.antonchuraev.messengerfortest.dataClasses.messages.Message
import com.antonchuraev.messengerfortest.views.chats.ChatPreviewView
import com.antonchuraev.messengerfortest.views.messages.MessageView

class AllMessagesRecyclerAdapter():BaseListItemsAdapter<Message, MessageView>() {

    override fun getCustomView(context: Context, viewType: Int): MessageView = MessageView(context)


}
