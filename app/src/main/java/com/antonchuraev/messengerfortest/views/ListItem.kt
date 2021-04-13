package com.antonchuraev.messengerfortest.views

interface ListItem {
    fun getItemType():ItemType
}

/**
 * типы для листов recycler view и тд
 */
enum class ItemType{
    UNDEFINED,
    CHAT_PREVIEW,
    MESSAGE;

    private var itemTypePosition = 0

    fun ItemType(itemTypePosition: Int) {
        this.itemTypePosition = itemTypePosition
    }

    fun ItemType() {
        itemTypePosition = ordinal
    }

    companion object {

        @JvmStatic
        public fun find(type: Int): ItemType {
            for (i in values().indices) {
                if (values()[i].getItemTypePosition() == type) return values()[i]
            }
            return ItemType.UNDEFINED
        }




    }


    fun getItemTypePosition(): Int {
        return itemTypePosition
    }

}