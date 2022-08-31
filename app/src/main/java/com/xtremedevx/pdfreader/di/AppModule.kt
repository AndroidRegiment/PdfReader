package com.xtremedevx.pdfreader.di

import android.app.Application
import com.xtremedevx.pdfreader.data.repository.MyRepository
import com.xtremedevx.pdfreader.data.repository.MyRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMyRepository(
        appContext: Application
    ): MyRepository {
        return MyRepositoryImpl(context = appContext)
    }

}