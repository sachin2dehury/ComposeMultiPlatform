package presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import domain.model.DetailModel
import domain.orZero

@Composable
fun DetailSection(modifier: Modifier = Modifier, data: DetailModel) {
    var dominantBgColor by remember {
        mutableStateOf(Color.Black)
    }
    var mutedBgColor by remember {
        mutableStateOf(Color.Transparent)
    }
    var dominantTextColor by remember {
        mutableStateOf(Color.White)
    }
    var mutedTextColor by remember {
        mutableStateOf(Color.Black)
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(mutedBgColor)
            .padding(16.dp)

    ) {
//        AsyncImage(
//            model = data.images,
//            contentDescription = "Image",
//            modifier = Modifier
//                .aspectRatio(305f / 425)
//                .clip(RoundedCornerShape(16.dp)),
//            onSuccess = {
//                val palette = Palette.from(it.result.drawable.toBitmap()).generate()
//                dominantBgColor = Color(palette.dominantSwatch?.rgb.orZero())
//                mutedBgColor = Color(palette.mutedSwatch?.rgb.orZero())
//                dominantTextColor = Color(palette.dominantSwatch?.bodyTextColor.orZero())
//                mutedTextColor = Color(palette.mutedSwatch?.bodyTextColor.orZero())
//            }
//        )
        Text(
            modifier = Modifier
                .padding(top = 16.dp)
                .align(Alignment.CenterHorizontally),
            text = data.titleEnglish.ifEmpty { data.title },
            style = MaterialTheme.typography.h1,
            color = mutedTextColor
        )

        Text(
            modifier = Modifier
                .padding(top = 12.dp)
                .background(dominantBgColor)
                .align(Alignment.CenterHorizontally),
            text = data.titleJapanese,
            style = MaterialTheme.typography.h1,
            color = dominantTextColor
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Rating : ${data.score}",
                style = MaterialTheme.typography.body1,
                color = mutedTextColor
            )
            Text(
                text = "Rank : ${data.rank}",
                style = MaterialTheme.typography.body1,
                color = mutedTextColor
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Episodes : ${data.episodes}",
                style = MaterialTheme.typography.body1,
                color = mutedTextColor
            )
            Text(
                text = data.duration,
                style = MaterialTheme.typography.body1,
                color = mutedTextColor
            )
        }

        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = "Air : ${data.aired}",
            style = MaterialTheme.typography.body1,
            color = mutedTextColor
        )

        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = "Genres : ${data.genres}",
            style = MaterialTheme.typography.body1,
            color = mutedTextColor
        )

        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = "Rating : ${data.rating}",
            style = MaterialTheme.typography.body1,
            color = mutedTextColor
        )

        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = "Background : \n\t${data.background}",
            style = MaterialTheme.typography.body2,
            color = mutedTextColor
        )

        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = "Synopsis : \n\t${data.synopsis}",
            style = MaterialTheme.typography.body2,
            color = mutedTextColor
        )

        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = "Opening : \n${data.openingTheme.joinToString("\n")}",
            style = MaterialTheme.typography.body1,
            color = mutedTextColor
        )

        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = "Ending : \n${data.endingTheme.joinToString("\n")}",
            style = MaterialTheme.typography.body1,
            color = mutedTextColor
        )
    }
}