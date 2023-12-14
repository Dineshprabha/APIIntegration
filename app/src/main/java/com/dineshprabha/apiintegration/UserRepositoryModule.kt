package com.dineshprabha.apiintegration

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class UserRepositoryModule {


//    //creating firebase repository using dagger
//    @Provides
//    fun getFirebaseRepository(): UserRepository{
//        return FirebaseRepository()
//    }

//    //creating SQL repository using dagger
//    @Provides
//    fun getSQLRepository(sqlRepository: SQLRepository): UserRepository{
//        return sqlRepository
//    }

    @Binds
    abstract fun getSQLRepository(sqlRepository: SQLRepository): UserRepository


}