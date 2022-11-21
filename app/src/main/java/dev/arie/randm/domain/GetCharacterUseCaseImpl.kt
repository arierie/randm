package dev.arie.randm.domain

import dev.arie.randm.mapper.CharacterMapper
import dev.arie.randm.model.Characters
import dev.arie.randm.ui.GetCharacterUseCase
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetCharacterUseCaseImpl @Inject constructor(
    private val repository: CharacterRepository,
    private val mapper: CharacterMapper
) : GetCharacterUseCase {

    override fun getCharacters(): Single<Characters> {
        return repository.fetchCharacters()
            .map(mapper::toCharacterList)
            .map(mapper::toCharacters)
    }
}
