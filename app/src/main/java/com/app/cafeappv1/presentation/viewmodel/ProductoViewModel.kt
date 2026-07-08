package com.app.cafeappv1.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.cafeappv1.domain.model.Producto
import com.app.cafeappv1.domain.usecase.ProductoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class ProductoViewModel(
    private val productoUseCase: ProductoUseCase
) : ViewModel() {
    private val _productos = MutableStateFlow<List<Producto>>(emptyList())
    val productos: StateFlow<List<Producto>> = _productos

    init {
        obtenerProductos()
    }

    private fun obtenerProductos() {
        viewModelScope.launch {
            try {
                val respuesta = productoUseCase.getProductos()
                _productos.value = respuesta

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}