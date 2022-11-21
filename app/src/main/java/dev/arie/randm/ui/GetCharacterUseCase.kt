package dev.arie.randm.ui

import dev.arie.randm.model.Characters
import io.reactivex.rxjava3.core.Single

interface GetCharacterUseCase {
    fun getCharacters(): Single<Characters>
}
