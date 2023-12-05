package presentation.detail.model

import domain.model.DetailModel

data class DetailUiState(
    val isLoading: Boolean = false,
    val data: DetailModel? = null,
    val error: String? = null
)
