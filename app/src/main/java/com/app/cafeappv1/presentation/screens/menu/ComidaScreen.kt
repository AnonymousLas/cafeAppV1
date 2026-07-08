package com.app.cafeappv1.presentation.screens.menu

import com.app.cafeappv1.presentation.screens.OrdenScreen
import com.app.cafeappv1.presentation.screens.ConfirmacionScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.app.cafeappv1.domain.model.Producto
import com.app.cafeappv1.presentation.screens.detallecafe.AmericanoScreen
import com.app.cafeappv1.presentation.screens.detallecafe.Cafe_LecheScreen
import com.app.cafeappv1.presentation.screens.detallecafe.CapuchinoScreen
import com.app.cafeappv1.presentation.screens.detallecafe.ExpressoScreen
import com.app.cafeappv1.presentation.screens.detallecafe.IrishScreen
import com.app.cafeappv1.presentation.screens.detallecafe.LatteScreen
import com.app.cafeappv1.presentation.screens.detallecafe.MatchaScreen
import com.app.cafeappv1.presentation.screens.detallecafe.MoccaScreen
import com.app.cafeappv1.presentation.screens.detallecomida.BrownieScreen
import com.app.cafeappv1.presentation.screens.detallecomida.EmpanadaScreen
import com.app.cafeappv1.presentation.screens.detallecomida.HamburguesaScreen
import com.app.cafeappv1.presentation.screens.detallecomida.Pan_chicharronScreen
import com.app.cafeappv1.presentation.screens.detallecomida.Pan_lomoScreen
import com.app.cafeappv1.presentation.screens.detallecomida.Pie_ManzanaScreen
import com.app.cafeappv1.presentation.screens.detallecomida.Triple_polloScreen
import com.app.cafeappv1.presentation.screens.detallecomida.WaflesScreen
import com.app.cafeappv1.presentation.viewmodel.PedidoViewModel
import com.app.cafeappv1.presentation.viewmodel.ProductoViewModel

@Composable
fun ComidaScreen(onVolver: () -> Unit,
                 productoViewModel: ProductoViewModel,
                 pedidoViewModel: PedidoViewModel) {

    var comidaSeleccionado by remember { mutableStateOf("") }
    val productos by productoViewModel.productos.collectAsState()

    var productoSeleccionado by remember {
        mutableStateOf<Producto?>(null)
    }

    when (comidaSeleccionado) {
        "brownie" -> BrownieScreen(
            onVolver = { comidaSeleccionado = "" },
            onOrdenar = {
                productoSeleccionado = productos.find {
                    it.nombre.equals("Brownie", ignoreCase = true)
                }?.copy(imagen = R.drawable.brownie3)

                comidaSeleccionado = "orden"
            }
        )

        "empanada"        -> EmpanadaScreen (
            onVolver = { comidaSeleccionado = "" },
            onOrdenar = {
                productoSeleccionado = productos.find {
                    it.nombre.equals("Empanada", ignoreCase = true)
                }?.copy(imagen = R.drawable.empanada)

                comidaSeleccionado = "orden"
            })
        "hamburguesa"         -> HamburguesaScreen (
            onVolver = { comidaSeleccionado = "" },
            onOrdenar = {
                productoSeleccionado = productos.find {
                    it.nombre.equals("Hamburguesa", ignoreCase = true)
                }?.copy(imagen = R.drawable.hamburguesa)

                comidaSeleccionado = "orden"
            })
        "pan_chicharron"         -> Pan_chicharronScreen (
            onVolver = { comidaSeleccionado = "" },
            onOrdenar = {
                productoSeleccionado = productos.find {
                    it.nombre.equals("Pan con Chicharron", ignoreCase = true)
                }?.copy(imagen = R.drawable.pan_chicharron)

                comidaSeleccionado = "orden"
            })
        "pan_lomo"       -> Pan_lomoScreen (
            onVolver = { comidaSeleccionado = "" },
            onOrdenar = {
                productoSeleccionado = productos.find {
                    it.nombre.equals("Pan con Lomo", ignoreCase = true)
                }?.copy(imagen = R.drawable.pan_lomo)

                comidaSeleccionado = "orden"
            })
        "pie_manzana"     -> Pie_ManzanaScreen  (
            onVolver = { comidaSeleccionado = "" },
            onOrdenar = {
                productoSeleccionado = productos.find {
                    it.nombre.equals("Pie de Manzana", ignoreCase = true)
                }?.copy(imagen = R.drawable.pie_manzana3)

                comidaSeleccionado = "orden"
            })
        "triple_pollo"    -> Triple_polloScreen (
            onVolver = { comidaSeleccionado = "" },
            onOrdenar = {
                productoSeleccionado = productos.find {
                    it.nombre.equals("Triple de Pollo", ignoreCase = true)
                }?.copy(imagen = R.drawable.brownie3)

                comidaSeleccionado = "orden"
            })
        "wafles"     -> WaflesScreen (
            onVolver = { comidaSeleccionado = "" },
            onOrdenar = {
                productoSeleccionado = productos.find {
                    it.nombre.equals("Waffles", ignoreCase = true)
                }?.copy(imagen = R.drawable.wafles)

                comidaSeleccionado = "orden"
            })

        "orden" -> {
            productoSeleccionado?.let { producto ->
                OrdenScreen(
                    producto = producto,
                    onVolver = { comidaSeleccionado = "" },
                    onPagar = { pedido ->
                        pedidoViewModel.crearPedido(pedido)
                        comidaSeleccionado = "confirmacion"
                    }
                )
            }
        }

        "confirmacion" -> ConfirmacionScreen(
            onSeguirComprando = {
                comidaSeleccionado = ""
            }
        )

        else -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF11131A))
                    .systemBarsPadding()
                    .padding(horizontal = 20.dp)
            ) {
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "< Menú",
                    color = Color(0xFFFFC107),
                    fontSize = 16.sp,
                    modifier = Modifier.clickable { onVolver() }
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Comidas",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(20.dp))

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    item { ComidaItem(imagen = R.drawable.triple_pollo,       nombre = "Triple de Pollo",            onClick = { comidaSeleccionado = "triple_pollo" }) }
                    item { ComidaItem(imagen = R.drawable.pan_chicharron,     nombre = "Pan con Chicharrón",            onClick = { comidaSeleccionado = "pan_chicharron"}) }
                    item { ComidaItem(imagen = R.drawable.pan_lomo,   nombre = "Pan con Lomo",         onClick = { comidaSeleccionado = "pan_lomo"}) }
                    item { ComidaItem(imagen = R.drawable.wafles,     nombre = "Waffles",            onClick = { comidaSeleccionado = "wafles"}) }
                    item { ComidaItem(imagen = R.drawable.hamburguesa,  nombre = "Hamburguesa",        onClick = { comidaSeleccionado = "hamburguesa"}) }
                    item { ComidaItem(imagen = R.drawable.empanada, nombre = "Empanada de Carne",   onClick = { comidaSeleccionado = "empanada"}) }
                    item { ComidaItem(imagen = R.drawable.brownie3,    nombre = "Brownie",           onClick = { comidaSeleccionado = "brownie"}) }
                    item { ComidaItem(imagen = R.drawable.pie_manzana3,  nombre = "Pie de Manzana", onClick = { comidaSeleccionado = "pie_manzana"}) }
                }
            }
        }
    }
}

@Composable
fun ComidaItem(imagen: Int, nombre: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
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