package presentation.detail

import domain.ResultType
import domain.usecase.DetailUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import presentation.detail.model.DetailUiState

class DetailViewModel(private val useCase: DetailUseCase) {

    private val _state = MutableStateFlow(DetailUiState())
    val state = _state.asStateFlow()

    fun getDetail(id: Int) = CoroutineScope(Dispatchers.IO).launch {
        useCase.invoke(id).onEach { result ->
            when (result) {
                is ResultType.Error -> {
                    _state.update {
                        it.copy(isLoading = false, error = result.message)
                    }
                }

                ResultType.Loading -> {
                    _state.update {
                        it.copy(isLoading = true, error = null)
                    }
                }

                is ResultType.Success -> {
                    _state.update {
                        it.copy(isLoading = false, error = null, data = result.data)
                    }
                }
            }
        }.launchIn(CoroutineScope(Dispatchers.IO))
    }
}