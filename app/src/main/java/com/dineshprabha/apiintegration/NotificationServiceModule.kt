package com.dineshprabha.apiintegration

import dagger.Module
import dagger.Provides
import javax.inject.Named


@Module
class NotificationServiceModule {

    @MessageQualifier
    @Provides
    fun getMessageService(): NotificationService{
        return MessageService()

    }

    @Named("email")
    @Provides
    fun getEmailService(emailService: EmailService): NotificationService{
        return MessageService()

    }
}