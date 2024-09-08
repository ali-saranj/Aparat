package ali.saranj.aparat.ui.screen.category

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CategoryDetailScreen(
    modifier: Modifier = Modifier,
    categoryId: String?,
    viewModel: CategoryDetailViewModel = hiltViewModel()
) {
    val event = viewModel::handelEvent
    val state = viewModel.categoryDetailState

    LaunchedEffect(event) {
        event.invoke(CategoryDetailEvent.LoadVideoByCategory(categoryId = categoryId!!.toInt()))
    }

    Scaffold { paddingValues ->

    }
}

@Preview(name = "CategoryScreen")
@Composable
private fun PreviewCategoryScreen() {
    CategoryDetailScreen(categoryId = "sdasd")
}