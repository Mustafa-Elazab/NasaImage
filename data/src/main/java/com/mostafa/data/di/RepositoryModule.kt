package com.mostafa.data.di


import com.mostafa.data.repository.NasaRepositoryImpl
import com.mostafa.domain.repository.NasaRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindNasaRepository(repository: NasaRepositoryImpl): NasaRepository


}