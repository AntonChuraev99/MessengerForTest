package com.antonchuraev.messengerfortest.dataClasses.chats

import com.antonchuraev.messengerfortest.dataClasses.messages.Message

/**
 * основной класс чата
 */
data class Chat(
        val id:Int,
        val chatPreview: ChatPreview,
        val chatData:ChatData,
        val messages:List<Message>,
        )
{

        companion object{

                fun generateRandomChat():Chat{
                        return Chat(0 , ChatPreview.generateRandom() , ChatData(usersCount =  3), Message.generateRandomList() )


                }

        }

}