package data.repository

import data.model.DetailRemoteModel

interface DetailRepository {
    suspend fun getDetails(id: Int): DetailRemoteModel
}