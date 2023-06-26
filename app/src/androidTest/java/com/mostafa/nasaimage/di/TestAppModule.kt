package com.mostafa.nasaimage.di

import com.mostafa.nasaimage.TestAppFragmentFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {

    @Provides
    @Named("TestFragmentFactory")
    fun provideTestFragmentFactory(): TestAppFragmentFactory {
        return TestAppFragmentFactory()
    }

}