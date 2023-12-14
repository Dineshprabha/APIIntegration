package com.dineshprabha.apiintegration

import android.util.Log
import javax.inject.Inject


interface NotificationService{
    fun send(to:String, from:String, body:String){

    }
}
class EmailService @Inject constructor() : NotificationService {

    override fun send(to:String, from:String, body:String){
        Log.i("DINESH", "Email sent")
    }
}


class MessageService : NotificationService{
    override fun send(to:String, from:String, body:String){
        Log.i("DINESH", "Email sent")
        Log.d("DINESH", "Message Sent" )
    }
}