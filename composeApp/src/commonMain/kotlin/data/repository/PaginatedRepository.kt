package data.repository

import data.model.PaginatedRemoteModel

interface PaginatedRepository {
    suspend fun getPaginatedList(page: Int, limit: Int, query: String?): PaginatedRemoteModel
}