package com.dineshprabha.apiintegration

import android.util.Log
import javax.inject.Inject


interface UserRepository{

    fun saveUser(email:String, password: String){
    }

}
class SQLRepository @Inject constructor() : UserRepository {

    override fun saveUser(email:String, password: String){
        Log.i("DINESH", "User saved in DB")
    }
}

class FirebaseRepository : UserRepository{
    override fun saveUser(email:String, password: String){
        Log.i("DINESH", "User saved in Firebase")
    }
}