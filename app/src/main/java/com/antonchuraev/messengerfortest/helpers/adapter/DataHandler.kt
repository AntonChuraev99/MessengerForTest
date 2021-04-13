package com.antonchuraev.messengerfortest.helpers.adapter

interface DataHandler<T> {
    fun invoke(model: T)
}