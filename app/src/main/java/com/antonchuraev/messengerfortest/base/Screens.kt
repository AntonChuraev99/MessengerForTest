package com.antonchuraev.messengerfortest.base

import androidx.fragment.app.Fragment
import com.antonchuraev.messengerfortest.fragments.allChats.AllChatsFlowFragment
import com.antonchuraev.messengerfortest.fragments.allChats.AllChatsFragment
import com.antonchuraev.messengerfortest.fragments.fullChat.FullChatFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

object Screens {

    object Flow{

        class AllChatsFlow:SupportAppScreen(){
             override fun getFragment(): Fragment = AllChatsFlowFragment.newInstance()
        }

    }


    object Screen {
        class AllChats: SupportAppScreen(){
            override fun getFragment(): Fragment = AllChatsFragment.newInstance()
        }

        class FullChat: SupportAppScreen(){
            override fun getFragment(): Fragment = FullChatFragment.newInstance()
        }


    }

}