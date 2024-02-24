package api

import data.RandomUser
import data.RandomUserApiResponse
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.flow

class HomeRepository {

    private suspend fun getRandomUser(): RandomUserApiResponse {
        val response = httpClient.get("https://randomuser.me/api/?page=1&results=20&seed=abc")
        return response.body()
    }

    fun getUsers() = flow {
        emit(getRandomUser().results)
    }
    suspend fun getUserWithoutFlow(): List<RandomUser> {
        return getRandomUser().results
    }
}