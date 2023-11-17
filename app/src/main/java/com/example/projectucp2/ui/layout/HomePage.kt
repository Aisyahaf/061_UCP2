package com.example.projectucp2.ui.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.projectucp2.R

@Composable
fun HomePage(
    onNextButtonClicked: () -> Unit
){
    val image = painterResource(id = R.drawable.logo)
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.padding_medium)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
        verticalAlignment = Alignment.Bottom
    ){
        Button(
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onErrorContainer),
            modifier = Modifier.weight(1f),
            onClick = onNextButtonClicked
        ) {
            Text(stringResource(R.string.lanjut))
        }
    }
}