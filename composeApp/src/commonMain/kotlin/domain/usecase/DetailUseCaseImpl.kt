package domain.usecase

import data.repository.DetailRepository
import domain.ResultType
import domain.toDetailModel
import kotlinx.coroutines.flow.flow

class DetailUseCaseImpl(private val repository: DetailRepository) : DetailUseCase {
    override suspend fun invoke(id: Int) = flow {
        emit(ResultType.Loading)
        try {
            val response = repository.getDetails(id)
            if (response.error.isNullOrEmpty() && response.data != null) {
                emit(ResultType.Success(response.data.toDetailModel()))
            } else {
                emit(
                    ResultType.Error(
                        response.messages?.values?.joinToString() ?: "Something went wrong!!"
                    )
                )
            }
        } catch (e: Exception) {
            emit(ResultType.Error(e.localizedMessage ?: "Something went wrong!!"))
        }
    }
}