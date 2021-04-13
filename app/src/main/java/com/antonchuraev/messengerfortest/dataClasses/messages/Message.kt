package com.antonchuraev.messengerfortest.dataClasses.messages

import android.util.Log
import com.antonchuraev.messengerfortest.dataClasses.users.User
import com.antonchuraev.messengerfortest.helpers.randomGenerators.RandomGenerator
import com.antonchuraev.messengerfortest.helpers.randomGenerators.RandomGenerator.generateRandomString
import com.antonchuraev.messengerfortest.views.ItemType
import com.antonchuraev.messengerfortest.views.ListItem
import kotlin.random.Random

data class Message (
        val id:Int,
        val userSender: User,
        val text:String,
        val date:String
        ):ListItem{

        /**
         * принадлежит ли сообщение пользователю приложения
         */
        fun isAppUserMessage():Boolean{
                return Random.nextBoolean()
        }

        override fun getItemType(): ItemType = ItemType.MESSAGE


        companion object{

                fun generateRandom():Message{

                        return Message(1, User(1, RandomGenerator.generateRandomString(until = 8) ) , generateRandomString(until = 30) , generateRandomString(until = 8))
                }

                fun generateRandomList():List<Message>{

                        return mutableListOf<Message>().apply {
                                repeat(20){
                                        add( generateRandom() )
                                }
                        }
                }

        }

}