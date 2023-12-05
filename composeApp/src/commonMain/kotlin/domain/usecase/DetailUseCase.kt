package domain.usecase

import domain.ResultType
import domain.model.DetailModel
import kotlinx.coroutines.flow.Flow

interface DetailUseCase {
    suspend operator fun invoke(id: Int): Flow<ResultType<DetailModel>>
}