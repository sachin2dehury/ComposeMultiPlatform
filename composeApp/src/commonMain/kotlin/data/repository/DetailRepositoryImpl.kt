package data.repository

import data.repository.DetailRepository
import data.AnimeService

class DetailRepositoryImpl(private val service: AnimeService) : DetailRepository {
    override suspend fun getDetails(id: Int) = service.getDetail(id)
}