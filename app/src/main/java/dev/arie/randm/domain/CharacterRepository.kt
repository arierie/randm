package dev.arie.randm.domain

import dev.arie.randm.CharacterQuery
import io.reactivex.rxjava3.core.Single

interface CharacterRepository {
    fun fetchCharacters(): Single<CharacterQuery.Data>
}
