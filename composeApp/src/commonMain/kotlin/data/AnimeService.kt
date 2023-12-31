package data

import data.model.DetailRemoteModel
import data.model.PaginatedRemoteModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimeService {

    @GET("v4/anime")
    suspend fun getPaginatedList(
        @Query("page") page: Int,
        @Query("limit") limit: Int,
        @Query("q") query: String?
    ): PaginatedRemoteModel

    @GET("v4/anime/{id}/full")
    suspend fun getDetail(@Path("id") id: Int): DetailRemoteModel

    companion object {
        const val BASE_URL = "https://api.jikan.moe"
    }
}