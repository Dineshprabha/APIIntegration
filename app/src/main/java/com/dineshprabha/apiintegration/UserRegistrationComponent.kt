package com.dineshprabha.apiintegration

import dagger.Component

@Component(modules = [UserRepositoryModule::class, NotificationServiceModule::class])
interface UserRegistrationComponent {

//    fun getUserRegistrationService() : UserRegistrationService
//
//    fun getEmailService(): EmailService


    fun inject(mainActivity: MainActivity)

}