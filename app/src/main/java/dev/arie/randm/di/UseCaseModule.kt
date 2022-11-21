package dev.arie.randm.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.arie.randm.domain.CharacterRepository
import dev.arie.randm.domain.GetCharacterUseCaseImpl
import dev.arie.randm.mapper.CharacterMapper
import dev.arie.randm.ui.GetCharacterUseCase

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideGetCharacterUseCase(
        characterRepository: CharacterRepository,
        mapper: CharacterMapper
    ): GetCharacterUseCase {
        return GetCharacterUseCaseImpl(characterRepository, mapper)
    }
}
