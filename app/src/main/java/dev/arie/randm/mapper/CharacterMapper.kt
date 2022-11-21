package dev.arie.randm.mapper

import dev.arie.randm.CharacterQuery
import dev.arie.randm.model.Characters
import dev.arie.randm.model.Origin
import javax.inject.Inject

class CharacterMapper @Inject constructor() {

    fun toCharacterList(query: CharacterQuery.Data?): List<dev.arie.randm.model.Character> {
        return query?.characters?.results?.map {
            dev.arie.randm.model.Character(
                id = it?.id ?: "",
                image = it?.image ?: "",
                name = it?.name ?: "",
                origin = Origin(
                    it?.origin?.id ?: "",
                    it?.origin?.name ?: ""
                ),
                status = it?.status ?: "",
                type = it?.type ?: "",
                species = it?.species ?: ""
            )
        } ?: listOf()
    }

    fun toCharacters(list: List<dev.arie.randm.model.Character>?): Characters {
        return Characters(list ?: listOf())
    }
}
