package com.antonchuraev.messengerfortest.dataClasses.chats

import com.antonchuraev.messengerfortest.helpers.randomGenerators.RandomGenerator.generateRandomString
import com.antonchuraev.messengerfortest.views.ItemType
import com.antonchuraev.messengerfortest.views.ListItem

/**
 * превью чата для главного экрана для ускоренния полчения данных из запроса
 */
data class ChatPreview(
        val chatId:Int,
        val chatName:String,
        val lastUserName:String, //имя пользователя последнего отправившего сообщение
        val lastText:String,
):ListItem{



        companion object{


                fun generateRandomList():List<ChatPreview>{

                        return mutableListOf<ChatPreview>().apply {
                                repeat(16){

                                        add(ChatPreview( 1,  generateRandomString(until = 10) , generateRandomString(until = 8 ), generateRandomString() )  )

                                }

                        }

                }

                fun generateRandom():ChatPreview{
                        return ChatPreview( 1,  generateRandomString(until = 10) , generateRandomString(until = 8 ), generateRandomString() )
                }

        }

        override fun getItemType(): ItemType = ItemType.CHAT_PREVIEW


}