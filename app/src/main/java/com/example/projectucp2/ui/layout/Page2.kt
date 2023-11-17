package com.example.projectucp2.ui.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.projectucp2.R
import com.example.projectucp2.data.DataForm

@Composable
fun PageTwo(
    dataForm : DataForm,
    onBackButtonClicked: ()-> Unit,
    modifier: Modifier = Modifier
){
    val  items = listOf(
        Pair(stringResource(R.string.nama), dataForm.nama),
        Pair(stringResource(R.string.nim), dataForm.nim),
        Pair(stringResource(R.string.konsentrasi), dataForm.konsentrasi),
        Pair(stringResource(R.string.judul), dataForm.judul),
        Pair(stringResource(R.string.dosen1), dataForm.dosbim),
        Pair(stringResource(R.string.dosen2), dataForm.dosbim),
    )

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column (
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {
            items.forEach{ item ->
                Column {
                    Text(item.first.uppercase(), fontWeight = FontWeight.Bold)
                    Text(text = item.second.toString(), fontSize = 18.sp)
                }
                Divider(
                    thickness = dimensionResource(R.dimen.thickness_divider)
                )
            }

            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))


            Row (
                modifier = Modifier
                    .weight(1f, false)
                    .padding(dimensionResource(R.dimen.padding_medium))
            ){
                Column (
                    verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
                ){
                    Button(
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onErrorContainer),
                        modifier = Modifier.fillMaxWidth(),
                        onClick = onBackButtonClicked
                    ) {
                        Text(stringResource(R.string.kembali))
                    }

                }
            }
        }
    }
}