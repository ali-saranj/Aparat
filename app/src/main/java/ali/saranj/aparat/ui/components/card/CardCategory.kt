package ali.saranj.aparat.ui.components.card

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardCategory(
    modifier: Modifier = Modifier,
    isCheck: Boolean,
    OnChangeClick: (isCheck: Boolean) -> Unit
) {

    var isCheck2 by remember {
        mutableStateOf(isCheck)
    }
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = if (isCheck2) Color(0xffea1d5d) else Color.White,

        ),
        onClick = {
            isCheck2 = !isCheck2
            OnChangeClick(isCheck2)
        }) {

        Text(
            modifier = Modifier
                .border(1.dp, Color(0xffea1d5d), RoundedCornerShape(60))
                .padding(4.dp),
            text = "CardCategory",
            style = MaterialTheme.typography.bodySmall,
            color = if (isCheck2) Color.White else Color(0xffea1d5d)
        )

    }
}


@Preview(name = "CardCategory")
@Composable
private fun PreviewCardCategory() {
    CardCategory(isCheck = false, ){

    }
}