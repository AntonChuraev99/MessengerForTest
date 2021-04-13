package com.antonchuraev.messengerfortest.views.messages

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import com.antonchuraev.messengerfortest.R
import com.antonchuraev.messengerfortest.dataClasses.messages.Message
import com.antonchuraev.messengerfortest.databinding.ViewMessageBinding
import com.antonchuraev.messengerfortest.helpers.extensions.toast
import com.antonchuraev.messengerfortest.views.CustomListItemView


class MessageView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0 )
    : CustomListItemView<ViewMessageBinding , Message>(context, attrs, defStyleAttr ) {

    override fun getLayoutRes(): Int = R.layout.view_message

    @SuppressLint("ResourceAsColor")
    override fun setData(message: Message){

        message.also {

            binding.text.apply {
                text = it.text

                // TODO refactoring dont wotk
                background = ContextCompat.getDrawable(context , if (it.isAppUserMessage()) R.drawable.shape_rect_green_r_16 else R.drawable.shape_rect_gray_r_16 ) //if ( it.isAppUserMessage() ) R.color.green else R.color.gray



            }





        }

    }




}
