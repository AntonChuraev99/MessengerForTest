package com.antonchuraev.messengerfortest.helpers.adapter

import android.content.Context
import com.antonchuraev.messengerfortest.dataClasses.chats.ChatPreview
import com.antonchuraev.messengerfortest.views.chats.ChatPreviewView

class AllChatsRecyclerAdapter():BaseListItemsAdapter<ChatPreview, ChatPreviewView>() {

    override fun getCustomView(context: Context, viewType: Int): ChatPreviewView = ChatPreviewView(context)


}
