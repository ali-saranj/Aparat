package ali.saranj.aparat.ui.components.button

import ali.saranj.aparat.data.models.Category
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ButtonCategory(
    modifier: Modifier = Modifier,
    category: Category,
    OnClick: (category: Category) -> Unit
) {
    Button(
        onClick = { OnClick(category) },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xffea1d5d))
    ) {
        Text(
            modifier = Modifier,
            text = category.name,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White
        )
    }
}

@Preview(name = "Butten")
@Composable
private fun PreviewButten() {
    ButtonCategory(
        category = Category(1.toString(), "test", "test"),
        OnClick = {}
    )
}