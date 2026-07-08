package com.app.cafeappv1.presentation.screens
import com.app.cafeappv1.domain.session.SessionManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.cafeappv1.R
import com.app.cafeappv1.di.AppContainer

@Composable
fun InicioScreen(container: AppContainer, navController: NavHostController) {
    var pestanaActual by remember { mutableStateOf("home") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF11131A))
    ) {
        val usuario by SessionManager.usuarioActual.collectAsState()

        when (pestanaActual) {
            "home" -> HomeContent(userName = usuario?.nombre ?: "")
            "menu" -> MenuScreen(
                productoViewModel = container.productoViewModel,
                pedidoViewModel = container.pedidoViewModel
            )
            "pedidos" -> PedidosScreen(
                pedidoViewModel = container.pedidoViewModel
            )
            "perfil" -> PerfilScreen(
                onCerrarSesion = {
                    SessionManager.cerrarSesion()
                    navController.navigate("principal") {
                        popUpTo(0)
                    }
                }
            )
        }

        NavigationBar(
            modifier = Modifier.align(Alignment.BottomCenter),
            containerColor = Color(0xFF1A1D26)
        ) {
            NavigationBarItem(
                selected = pestanaActual == "home",
                onClick = { pestanaActual = "home" },
                icon = { Icon(Icons.Default.Home, contentDescription = null) },
                label = { Text("Inicio") }
            )

            NavigationBarItem(
                selected = pestanaActual == "menu",
                onClick = { pestanaActual = "menu" },
                icon = { Icon(Icons.Default.Menu, contentDescription = null) },
                label = { Text("Menú") }
            )

            NavigationBarItem(
                selected = pestanaActual == "pedidos",
                onClick = { pestanaActual = "pedidos" },
                icon = { Icon(Icons.Default.ShoppingCart, contentDescription = null) },
                label = { Text("Pedidos") }
            )

            NavigationBarItem(
                selected = pestanaActual == "perfil",
                onClick = { pestanaActual = "perfil" },
                icon = { Icon(Icons.Default.Person, contentDescription = null) },
                label = { Text("Perfil") }
            )
        }
    }
}

@Composable
fun HomeContent(userName: String = "") {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp)
            .padding(bottom = 100.dp)
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp),
            shape = RoundedCornerShape(24.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.linearGradient(
                            colors = listOf(
                                Color(0xFF2C1B12),
                                Color(0xFF1A0F0A)
                            )
                        )
                    )
                    .padding(20.dp)
            ) {
                Column(modifier = Modifier.align(Alignment.CenterStart)) {
                    Text(
                        text = "Bienvenido de vuelta,",
                        color = Color.LightGray,
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = userName,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                Text(
                    text = "☕",
                    fontSize = 50.sp,
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
        }

        Spacer(modifier = Modifier.height(28.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Novedades",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Ver todo",
                color = Color(0xFFFFC107),
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        LazyRow(horizontalArrangement = Arrangement.spacedBy(14.dp)) {
            item {
                NovedadCard(
                    emoji = "📍",
                    titulo = "¡Abrimos nuevo local!",
                    descripcion = "Visítanos en Miraflores."
                )
            }

            item {
                NovedadCard(
                    emoji = "❄️",
                    titulo = "Especial de Invierno",
                    descripcion = "Prueba el nuevo Latte Avellana."
                )
            }

            item {
                Card(
                    modifier = Modifier
                        .width(160.dp)
                        .height(190.dp),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF1E212B)
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .padding(12.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.perfil),
                            contentDescription = "Trae tu taza",
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(90.dp)
                                .clip(RoundedCornerShape(12.dp)),
                            contentScale = ContentScale.Crop
                        )

                        Text(
                            text = "Trae tu taza",
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Y obtén un 10% de dscto.",
                            color = Color.Gray,
                            fontSize = 11.sp
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(28.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Promociones",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Ver todo",
                color = Color(0xFFFFC107),
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            PromoCard(
                fondo1 = Color(0xFFD89E32),
                fondo2 = Color(0xFFF3B74A),
                titulo = "🔥 ¡Combate el frío!",
                descripcion = "30% OFF en Capuchinos y Mokas",
                codigo = "Cód: INVIERNO30",
                emoji = "🧣",
                textoOscuro = true
            )

            PromoCard(
                fondo1 = Color(0xFF8B5E3C),
                fondo2 = Color(0xFFA0714F),
                titulo = "🥐 Combo Mañanero",
                descripcion = "Americano + Croissant por S/. 15.00",
                codigo = "Cód: COMBO15",
                emoji = "☀️",
                textoOscuro = false
            )

            PromoCard(
                fondo1 = Color(0xFF3F4E75),
                fondo2 = Color(0xFF536796),
                titulo = "🍩 Afternoon Happy Hour",
                descripcion = "2x1 en todos los Frappes de 4pm a 7pm",
                codigo = "Cód: HAPPY2X1",
                emoji = "✨",
                textoOscuro = false
            )
        }
    }
}

@Composable
fun NovedadCard(
    emoji: String,
    titulo: String,
    descripcion: String
) {
    Card(
        modifier = Modifier
            .width(160.dp)
            .height(190.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1E212B)
        )
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .background(Color(0xFF2A2E3D), RoundedCornerShape(12.dp))
            ) {
                Text(
                    text = emoji,
                    fontSize = 32.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Text(
                text = titulo,
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = descripcion,
                color = Color.Gray,
                fontSize = 11.sp
            )
        }
    }
}

@Composable
fun PromoCard(
    fondo1: Color,
    fondo2: Color,
    titulo: String,
    descripcion: String,
    codigo: String,
    emoji: String,
    textoOscuro: Boolean
) {
    val colorTitulo = if (textoOscuro) Color.Black else Color.White
    val colorDescripcion = if (textoOscuro) Color(0xFF422206) else Color(0xFFF5E6D3)
    val colorCodigoFondo = if (textoOscuro) Color.Black.copy(alpha = 0.15f) else Color.White.copy(alpha = 0.2f)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(110.dp),
        shape = RoundedCornerShape(18.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(fondo1, fondo2)
                    )
                )
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = titulo,
                    color = colorTitulo,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = descripcion,
                    color = colorDescripcion,
                    fontSize = 13.sp
                )

                Spacer(modifier = Modifier.height(6.dp))

                Box(
                    modifier = Modifier
                        .background(colorCodigoFondo, RoundedCornerShape(6.dp))
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = codigo,
                        color = colorTitulo,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Text(
                text = emoji,
                fontSize = 32.sp
            )
        }
    }
}