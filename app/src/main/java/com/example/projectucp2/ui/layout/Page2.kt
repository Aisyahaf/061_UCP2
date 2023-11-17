package com.example.projectucp2.ui.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
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

    }
}