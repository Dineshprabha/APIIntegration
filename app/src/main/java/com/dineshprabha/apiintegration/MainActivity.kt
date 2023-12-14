package com.dineshprabha.apiintegration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val BASE_URL = "https://jsonplaceholder.typicode.com/"
    private val TAG = "CHECK_RESPONSE"

    //Manual dependency injection
//    private val userRepository = UserRepository()
//    private val emailService = EmailService()


        //Using dagger field injection
    @Inject
    lateinit var userRegistrationService: UserRegistrationService
    @Inject
    lateinit var emailService: EmailService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Using retrofit api calling
//        getAllComments()

        //Using Coroutines calling retrofit api call
//        getCoroutineAllComments()


        //creating object for dagger build component for userRegistration
        val component = DaggerUserRegistrationComponent.builder().build()


        //dependency by defining services in component class
//        val userRegistrationService = component.getUserRegistrationService()


        //using field injection method in activity reference
        component.inject(this)
        userRegistrationService.registerUser("dinesh@gmail.com", "123456")
    }

    //without coroutines handling api response using retrofit
    private fun getAllComments(){
        val api = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)

        api.getComments().enqueue(object : Callback<List<Comments>>{
            override fun onResponse(
                call: Call<List<Comments>>,
                response: Response<List<Comments>>
            ) {
                if (response.isSuccessful){
                    response.body()?.let {
                        for (comment in it){
                            Log.i(TAG, "Response: ${comment.body}")
                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<Comments>>, t: Throwable) {
                Log.i(TAG, "onFailure: ${t.message}")
            }

        })
    }



    //with coroutines handling api response using retrofit
    private fun getCoroutineAllComments(){
        val api = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(MyApi::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            val response = api.getAllComments()

            if (response.isSuccessful){
                for (comment in response.body()!!){
                    Log.i(TAG, "getAllComments : ${comment.email} ")
                }
            }
        }
    }
}