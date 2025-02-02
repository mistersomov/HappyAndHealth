package com.mistersomov.tictactrick.presentation.view

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.mistersomov.tictactrick.presentation.R
import com.mistersomov.tictactrick.presentation.extension.PreviewPhone

@Composable
fun GameDialog(
    title: String,
    onRestart: (() -> Unit)? = null,
) {
    Dialog(
        onDismissRequest = {},
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(8.dp),
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Text(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .wrapContentSize(),
                    text = title,
                )
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                ) {
                    DialogButton(
                        icon = R.drawable.ic_baseline_refresh_24,
                        onClick = { onRestart?.invoke() }
                    )
                }
            }
        }
    }
}

@Composable
private fun DialogButton(
    @DrawableRes icon: Int,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .background(color = Color.Blue, shape = RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            modifier = Modifier
                .size(64.dp)
                .clickable { onClick() },
            contentDescription = stringResource(R.string.reset),
            painter = painterResource(icon),
        )
    }
}

@PreviewPhone
@Composable
private fun GameDialogPreview() {
    GameDialog("Victory!")
}