package dev.arie.randm.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.arie.randm.data.CharacterRepositoryImpl
import dev.arie.randm.data.DataSource
import dev.arie.randm.domain.CharacterRepository

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideCharacterRepository(dataSource: DataSource): CharacterRepository {
        return CharacterRepositoryImpl(dataSource)
    }
}
