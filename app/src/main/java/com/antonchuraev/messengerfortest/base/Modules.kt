package com.antonchuraev.messengerfortest.base

import com.antonchuraev.messengerfortest.base.koin.appModule
import com.antonchuraev.messengerfortest.base.koin.navigationModule

val appComponent = listOf(
    appModule,
    navigationModule,

)