package dev.arie.randm.data

import dev.arie.randm.CharacterQuery
import dev.arie.randm.domain.CharacterRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val dataSource: DataSource
): CharacterRepository {

    override fun fetchCharacters(): Single<CharacterQuery.Data> {
        return dataSource.fetchCharacter(CharacterQuery())
    }
}
