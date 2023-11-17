package com.example.projectucp2.ui.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.projectucp2.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PageOne(
    pilihanDosbim: List<String>,
    onSelectionChanged: (String) ->Unit,
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    modifier: Modifier = Modifier
){
    var namaText by remember {
        mutableStateOf("")
    }
    var nimText by remember {
        mutableStateOf("")
    }
    var konsenText by remember {
        mutableStateOf("")
    }
    var judulText by remember {
        mutableStateOf("")
    }

    var listData: MutableList<String> = mutableListOf(namaText, nimText, konsenText, judulText)
    var dosbimYgDipilih by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedTextField(
            value = namaText,
            onValueChange = {namaText = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium)),
            label = { Text(text = stringResource(id = R.string.nama)) }
        )

        OutlinedTextField(
            value = nimText,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium)),
            label = { Text(text = stringResource(id = R.string.nim))},
            onValueChange = {nimText = it}
        )

        OutlinedTextField(
            value = konsenText,
            onValueChange = {konsenText = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium)),
            label = { Text(text = stringResource(id = R.string.konsentrasi)) }
        )

        OutlinedTextField(
            value = judulText,
            onValueChange = {judulText = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium)),
            label = { Text(text = stringResource(id = R.string.judul)) }
        )

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_medium))
            ) {
                pilihanDosbim.forEach{ item ->
                    Row (
                        modifier = Modifier.selectable(selected = dosbimYgDipilih == item,
                            onClick = {
                                dosbimYgDipilih = item
                                onSelectionChanged(item)
                            }
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        RadioButton(
                            selected = dosbimYgDipilih == item,
                            onClick = {
                                dosbimYgDipilih = item
                                onSelectionChanged(item)}
                        )
                        Text(item)
                    }
                }
            }

            Column(
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_medium))
            ) {
                pilihanDosbim.forEach{ item ->
                    Row (
                        modifier = Modifier.selectable(selected = dosbimYgDipilih == item,
                            onClick = {
                                dosbimYgDipilih = item
                                onSelectionChanged(item)
                            }
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        RadioButton(
                            selected = dosbimYgDipilih == item,
                            onClick = {
                                dosbimYgDipilih = item
                                onSelectionChanged(item)}
                        )
                        Text(item)
                    }
                }
            }
        }

        Button(onClick = { onSubmitButtonClicked(listData)}) {
            Text(text = stringResource(id = R.string.submit))
        }
    }
}