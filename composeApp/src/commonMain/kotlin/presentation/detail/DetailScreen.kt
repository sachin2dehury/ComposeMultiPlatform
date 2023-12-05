package presentation.detail

import AppModule.viewModel
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import presentation.ErrorSection

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    id: Int,
) {
    Box(modifier = modifier) {
        LaunchedEffect(key1 = Unit, block = {
            viewModel.getDetail(id)
        })
        val state = viewModel.state.collectAsState().value
        if (state.isLoading) {
            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth()
            )
        }
        if (!state.error.isNullOrEmpty()) {
            ErrorSection(error = state.error) {
                viewModel.getDetail(id)
            }
        }
        if (state.data != null) {
            DetailSection(data = state.data)
        }
    }
}

