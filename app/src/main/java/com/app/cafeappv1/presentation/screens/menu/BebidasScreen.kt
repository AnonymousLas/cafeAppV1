package com.app.cafeappv1.presentation.screens.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.cafeappv1.R
import androidx.compose.foundation.clickable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.app.cafeappv1.presentation.screens.detallebebida.AnisScreen
import com.app.cafeappv1.presentation.screens.detallebebida.ChocolateScreen
import com.app.cafeappv1.presentation.screens.detallebebida.JugoFresaScreen
import com.app.cafeappv1.presentation.screens.detallebebida.JugoPapayaScreen
import com.app.cafeappv1.presentation.screens.detallebebida.ManzanillaScreen
import com.app.cafeappv1.presentation.screens.detallebebida.TeJengibreScreen
import com.app.cafeappv1.presentation.screens.detallebebida.TeNegroScreen
import com.app.cafeappv1.presentation.screens.detallebebida.TeVerdeScreen
import com.app.cafeappv1.presentation.viewmodel.PedidoViewModel
import com.app.cafeappv1.presentation.viewmodel.ProductoViewModel

@Composable
fun BebidasScreen(onVolver: () -> Unit,
                  productoViewModel: ProductoViewModel,
                  pedidoViewModel: PedidoViewModel) {

    var bebidaSeleccionado by remember { mutableStateOf("") }

    when(bebidaSeleccionado){

        "anis"      -> AnisScreen       (onVolver = { bebidaSeleccionado = "" })
        "chocolate"     -> ChocolateScreen     (onVolver = { bebidaSeleccionado = "" })
        "jugo_fresa"      -> JugoFresaScreen       (onVolver = { bebidaSeleccionado = "" })
        "jugo_papaya"      -> JugoPapayaScreen(onVolver = { bebidaSeleccionado = "" })
        "manzanilla"    -> ManzanillaScreen    (onVolver = { bebidaSeleccionado = "" })
        "te_jengibre"  -> TeJengibreScreen  (onVolver = { bebidaSeleccionado = "" })
        "te_negro" -> TeNegroScreen   (onVolver = { bebidaSeleccionado = "" })
        "te_verde"  -> TeVerdeScreen(onVolver = { bebidaSeleccionado = "" })

        else -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF11131A))
                    .systemBarsPadding()
                    .padding(horizontal = 20.dp)
            ) {

                Spacer(modifier = Modifier.height(10.dp))

                // BOTON VOLVER
                Text(
                    text = "< Menú",
                    color = Color(0xFFFFC107),
                    fontSize = 16.sp,
                    modifier = Modifier.clickable { onVolver() }
                )

                Spacer(modifier = Modifier.height(10.dp))

                // TITULO
                Text(
                    text = "Infusiones Y Bebidas",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(20.dp))

                // GRID DE CAFES
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    item { BebidasItem(imagen = R.drawable.teverde1,    nombre = "Té Verde",        onClick = { bebidaSeleccionado =  "te_verde"    })}
                    item { BebidasItem(imagen = R.drawable.teanis,      nombre = "Anís",            onClick = { bebidaSeleccionado =  "anis"        })}
                    item { BebidasItem(imagen = R.drawable.tejengibre,  nombre = "Té de Jengibre",  onClick = { bebidaSeleccionado =  "te_jengibre" })}
                    item { BebidasItem(imagen = R.drawable.tenegro1,    nombre = "Té Negro",        onClick = { bebidaSeleccionado =  "te_negro"    })}
                    item { BebidasItem(imagen = R.drawable.manzanilla1, nombre = "Manzanilla",      onClick = { bebidaSeleccionado =  "manzanilla"  })}
                    item { BebidasItem(imagen = R.drawable.chocolate,   nombre = "Chocolate",       onClick = { bebidaSeleccionado =  "chocolate"   })}
                    item { BebidasItem(imagen = R.drawable.jugofresa,   nombre = "Jugo de Fresa",   onClick = { bebidaSeleccionado =  "jugo_fresa"  })}
                    item { BebidasItem(imagen = R.drawable.papaya1,     nombre = "Jugo de Papaya",  onClick = { bebidaSeleccionado =  "jugo_papaya" })}
                }
            }
        }
    }
}


@Composable
fun BebidasItem(imagen: Int, nombre: String, onClick : () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable{ onClick() }
        ) {
        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(Color(0xFF232733)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = imagen),
                contentDescription = nombre,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(100.dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = nombre,
            color = Color.White,
            fontSize = 14.sp
        )
    }
}