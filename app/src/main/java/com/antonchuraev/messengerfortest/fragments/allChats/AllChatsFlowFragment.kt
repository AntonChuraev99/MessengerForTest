package com.antonchuraev.messengerfortest.fragments.allChats

import android.view.View
import com.antonchuraev.messengerfortest.base.FlowFragment
import com.antonchuraev.messengerfortest.base.Screens
import ru.terrakok.cicerone.android.support.SupportAppScreen

class AllChatsFlowFragment : FlowFragment() {
    override val launchScreen: SupportAppScreen = Screens.Screen.AllChats()

    override fun onCreateView(rootView: View) {

    }


    companion object {
        fun newInstance() = AllChatsFlowFragment().apply {
            arguments = null
        }
    }


}