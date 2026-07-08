package com.app.cafeappv1.presentation.screens.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
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
import com.app.cafeappv1.presentation.screens.ConfirmacionScreen
import com.app.cafeappv1.presentation.screens.OrdenScreen
import com.app.cafeappv1.presentation.screens.detallecafe.*
import com.app.cafeappv1.presentation.viewmodel.PedidoViewModel
import com.app.cafeappv1.presentation.viewmodel.ProductoViewModel

@Composable
fun CafeScreen(onVolver: () -> Unit,
               productoViewModel: ProductoViewModel,
               pedidoViewModel: PedidoViewModel)
{
    var cafeSeleccionado by remember { mutableStateOf("") }
    var productoSeleccionado by remember { mutableStateOf<Producto?>(null) }

    val productos by productoViewModel.productos.collectAsState()

    when (cafeSeleccionado) {
        "mocca" -> MoccaScreen(
            onVolver = { cafeSeleccionado = "" },
            onOrdenar = {
                productoSeleccionado = productos.find { it.nombre.equals("Mocca", ignoreCase = true) }
                    ?.copy(imagen = R.drawable.moca)

                cafeSeleccionado = "orden"
            }
        )

        "matcha" -> MatchaScreen(
            onVolver = { cafeSeleccionado = "" },
            onOrdenar = {
                productoSeleccionado = productos.find {it.nombre.equals("Matcha", ignoreCase = true) }
                    ?.copy(imagen = R.drawable.matcha1)

                cafeSeleccionado = "orden"
            }
        )

        "latte" -> LatteScreen(
            onVolver = { cafeSeleccionado = "" },
            onOrdenar = {
                productoSeleccionado = productos.find {it.nombre.equals("Latte", ignoreCase = true) }
                    ?.copy(imagen = R.drawable.latte1)

                cafeSeleccionado = "orden"
            }
        )

        "irish" -> IrishScreen(
            onVolver = { cafeSeleccionado = "" },
            onOrdenar = {
                productoSeleccionado = productos.find {it.nombre.equals("Irish", ignoreCase = true) }
                    ?.copy(imagen = R.drawable.irish1)

                cafeSeleccionado = "orden"
            }
        )

        "expreso" -> ExpressoScreen(
            onVolver = { cafeSeleccionado = "" },
            onOrdenar = {
                productoSeleccionado = productos.find {it.nombre.equals("Expresso", ignoreCase = true) }
                    ?.copy(imagen = R.drawable.expresso)

                cafeSeleccionado = "orden"
            }
        )

        "capuchino" -> CapuchinoScreen(
            onVolver = { cafeSeleccionado = "" },
            onOrdenar = {
                productoSeleccionado = productos.find {it.nombre.equals("Capuchino", ignoreCase = true) }
                    ?.copy(imagen = R.drawable.capuchino)

                cafeSeleccionado = "orden"
            }
        )

        "cafe_leche" -> Cafe_LecheScreen(
            onVolver = { cafeSeleccionado = "" },
            onOrdenar = {
                productoSeleccionado = productos.find {it.nombre.equals("Café con Leche", ignoreCase = true) }
                    ?.copy(imagen = R.drawable.cafeleche1)

                cafeSeleccionado = "orden"
            }
        )

        "americano" -> AmericanoScreen(
            onVolver = { cafeSeleccionado = "" },
            onOrdenar = {
                productoSeleccionado = productos.find {it.nombre.equals("Americano Helado", ignoreCase = true) }
                    ?.copy(imagen = R.drawable.matcha1)

                cafeSeleccionado = "orden"
            }
        )

        "orden" -> {
            productoSeleccionado?.let { producto ->
                OrdenScreen(
                    producto = producto,
                    onVolver = {
                        cafeSeleccionado = ""
                    },
                    onPagar = { pedido ->
                        pedidoViewModel.crearPedido(pedido)
                        cafeSeleccionado = "confirmacion"
                    }
                )
            }
        }

        "confirmacion" -> ConfirmacionScreen(
            onSeguirComprando = {
                cafeSeleccionado = ""
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
                    text = "Cafés",
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
                    item {
                        CafeItem(
                            imagen = R.drawable.moca,
                            nombre = "Mocca",
                            onClick = { cafeSeleccionado = "mocca" }
                        )
                    }

                    item {
                        CafeItem(
                            imagen = R.drawable.latte1,
                            nombre = "Latte",
                            onClick = { cafeSeleccionado = "latte" }
                        )
                    }

                    item {
                        CafeItem(
                            imagen = R.drawable.expresso,
                            nombre = "Expresso",
                            onClick = { cafeSeleccionado = "expreso" }
                        )
                    }

                    item {
                        CafeItem(
                            imagen = R.drawable.irish1,
                            nombre = "Irish",
                            onClick = { cafeSeleccionado = "irish" }
                        )
                    }

                    item {
                        CafeItem(
                            imagen = R.drawable.capuchino,
                            nombre = "Capuchino",
                            onClick = { cafeSeleccionado = "capuchino" }
                        )
                    }

                    item {
                        CafeItem(
                            imagen = R.drawable.cafeleche1,
                            nombre = "Café con Leche",
                            onClick = { cafeSeleccionado = "cafe_leche" }
                        )
                    }

                    item {
                        CafeItem(
                            imagen = R.drawable.matcha1,
                            nombre = "Matcha",
                            onClick = { cafeSeleccionado = "matcha" }
                        )
                    }

                    item {
                        CafeItem(
                            imagen = R.drawable.americano,
                            nombre = "Americano Helado",
                            onClick = { cafeSeleccionado = "americano" }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CafeItem(
    imagen: Int,
    nombre: String,
    onClick: () -> Unit
) {
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