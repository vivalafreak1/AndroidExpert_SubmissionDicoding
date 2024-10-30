import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.arieftaufikrahman.wibuapp.R
import com.arieftaufikrahman.wibuapp.core.domain.model.Data

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AnimeGrid(
    animeList: List<Data>,
    onClick: (Data) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier,
        contentPadding = PaddingValues(8.dp)
    ) {
        items(animeList.size) { index ->
            val anime = animeList[index]
            AnimeGridItem(data = anime, index = index, onClick = { onClick(anime) })
        }
    }
}

@Composable
fun AnimeGridItem(
    data: Data,
    index: Int, // Receive index here
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Box(
        modifier = modifier
            .padding(8.dp)
            .clip(MaterialTheme.shapes.medium)
            .clickable { onClick() } // Make item clickable for navigation
    ) {
        // Image and rank overlay
        AsyncImage(
            model = ImageRequest.Builder(context).data(data.images.webp.image_url).build(),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        // Rank text at the top-left corner, using index + 1 for 1-based numbering
        Text(
            text = "#${index + 1}", // Display as #1, #2, etc.
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(8.dp),
            color = colorResource(id = R.color.body),
            style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Bold)
        )

        // Title with a black background and low opacity
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(8.dp)
                .drawBehind {
                    drawRect(color = Color.Black.copy(alpha = 0.6f))
                }
        ) {
            Text(
                text = data.title,
                style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
                color = colorResource(id = R.color.text_title),
                maxLines = 3
            )
        }
    }
}