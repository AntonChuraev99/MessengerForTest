package com.antonchuraev.messengerfortest.views

import androidx.annotation.NonNull

/**
 * Интерфейс для view-элементов с данными
 */
interface DataView<M> {
    fun setData(@NonNull model: M)
}