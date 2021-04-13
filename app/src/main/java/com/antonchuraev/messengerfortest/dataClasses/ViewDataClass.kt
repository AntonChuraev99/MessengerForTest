package com.antonchuraev.messengerfortest.dataClasses

/**
 * интерфейс для data классов к которым будут привязаны View
 * для CustomRecylerAdapter
 * @see CustomRecylerAdapter
 */
interface ViewDataClass{
    fun getViewType():Int
    fun getViewLayout():Int
}