package com.antonchuraev.messengerfortest.views.chats

import android.content.Context
import android.util.AttributeSet
import com.antonchuraev.messengerfortest.R
import com.antonchuraev.messengerfortest.dataClasses.chats.ChatPreview
import com.antonchuraev.messengerfortest.databinding.ViewChatPreviewBinding
import com.antonchuraev.messengerfortest.views.CustomListItemView


class ChatPreviewView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0 )
    : CustomListItemView<ViewChatPreviewBinding , ChatPreview>(context, attrs, defStyleAttr ) {

    override fun getLayoutRes(): Int = R.layout.view_chat_preview

    override fun setData(chatModel: ChatPreview){

        chatModel.apply {
            binding.chatName.text = chatName
            binding.lastUserName.text = context.resources.getString(R.string.text_colon , lastUserName)
            binding.text.text = lastText
        }

    }




}
