package com.example.projectucp2.ui.layout

import androidx.compose.foundation.layout.padding
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projectucp2.R
import com.example.projectucp2.data.DataSource.dosbim

enum class PengelolaHalaman{
    Home,
    Form,
    Summary
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormulirJudulAppBar(
    bisaNavigasiBack: Boolean,
    navigasiUp: () -> Unit,
    modifier: Modifier = Modifier
){
    TopAppBar(
        title = { Text(stringResource(id = R.string.app_name), fontFamily = FontFamily.Serif) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.errorContainer
        ),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormulirApp(
    viewModel : OrderViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){
    Scaffold(
        topBar = {
            FormulirJudulAppBar(
                bisaNavigasiBack = false,
                navigasiUp = {}
            )
        }
    ) {innerPadding ->
        val uiState by viewModel.stateUI.collectAsState()
        NavHost(
            navController = navController,
            startDestination = PengelolaHalaman.Home.name,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = PengelolaHalaman.Home.name){
                HomePage (
                    onNextButtonClicked = {navController.navigate(PengelolaHalaman.Form.name)
                    }
                )
            }
            composable(route = PengelolaHalaman.Form.name){
                val context = LocalContext.current
                PageOne (
                    pilihanDosbim = dosbim.map{id -> context.resources.getString(id)},
                    onSelectionChanged = {viewModel.setDosbim(it)},
                    onSubmitButtonClicked = {navController.navigate(PengelolaHalaman.Summary.name)},
                )
            }
            composable(route = PengelolaHalaman.Summary.name){
                PageTwo (
                    dataForm = uiState,
                    onBackButtonClicked = {cancelOrderAndNavigateToForm(navController) }
                )
            }
        }

    }
}

private fun cancelOrderAndNavigateToForm(
    navController: NavHostController
){
    navController.popBackStack(PengelolaHalaman.Form.name,
        inclusive = false)
}