package presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ErrorSection(
    modifier: Modifier = Modifier,
    error: String,
    callback: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally),
            text = error,
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.error,
        )
        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            onClick = {
                callback.invoke()
            }) {
            Text(
                modifier = Modifier.padding(4.dp),
                text = "Try again",
                style = MaterialTheme.typography.body1,
            )
        }
    }
}