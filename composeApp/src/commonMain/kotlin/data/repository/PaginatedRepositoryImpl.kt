package data.repository

import data.AnimeService

class PaginatedRepositoryImpl(private val service: AnimeService) : PaginatedRepository {
    override suspend fun getPaginatedList(
        page: Int,
        limit: Int,
        query: String?
    ) = service.getPaginatedList(page, limit, query)
}