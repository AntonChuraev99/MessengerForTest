package com.antonchuraev.messengerfortest.helpers.randomGenerators

import kotlin.random.Random

object RandomGenerator {

    val source = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

    fun generateRandomString( until:Int = 50 ):String{
        return (1..Random.nextInt(3,until) )
                .map { i -> Random.nextInt(0, 25) }
                .map(source::get)
                .joinToString("");
    }
}