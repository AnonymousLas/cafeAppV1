package com.app.cafeappv1.presentation.components


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.app.cafeappv1.presentation.event.EventBus
import com.app.cafeappv1.presentation.event.UIEvent

@Composable
fun AppScaffold(
    navController: NavHostController,
    content: @Composable (PaddingValues) -> Unit
){
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        EventBus.events.collect { event ->
            when (event){
                is UIEvent.Success -> { snackbarHostState.showSnackbar(
                    SnackbarCustom(message = event.mensaje, status = SnackbarStatus.SUCCESS)
                ) }
                is UIEvent.Error -> { snackbarHostState.showSnackbar(
                    SnackbarCustom(message = event.mensaje, status = SnackbarStatus.ERROR)
                ) }
                is UIEvent.Warning -> { snackbarHostState.showSnackbar(
                    SnackbarCustom(message = event.mensaje, status = SnackbarStatus.WARNING)
                ) }
            }
        }
    }

    Scaffold(

        bottomBar = { AppBottomBar(navController) },
        snackbarHost = { SnackbarHost(snackbarHostState){data ->
            val custom = data.visuals as? SnackbarCustom
            if(custom!=null){
                val status = custom.status
                Snackbar(
                    containerColor = status.backgroundColor,
                    contentColor = status.textColor,
                    modifier = Modifier.padding(12.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = status.icono,
                            contentDescription = status.iconoDesc,
                            tint = status.textColor
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(custom.message)
                    }
                }
            }
        } }
    ) {paddingValues ->
        content(paddingValues)
    }
}