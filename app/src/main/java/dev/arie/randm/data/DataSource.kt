package dev.arie.randm.data

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.rx3.rxQuery
import com.apollographql.apollo3.rx3.rxSingle
import dev.arie.randm.CharacterQuery
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class DataSource @Inject constructor(
    private val apolloClient: ApolloClient
) {

    fun fetchCharacter(query: CharacterQuery): Single<CharacterQuery.Data> {
        return apolloClient.query(query).rxSingle()
            .map { q -> q.data }
    }
}
