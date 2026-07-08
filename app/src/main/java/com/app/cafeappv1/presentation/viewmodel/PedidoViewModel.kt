package com.app.cafeappv1.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.cafeappv1.domain.model.Pedido
import com.app.cafeappv1.domain.usecase.PedidoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PedidoViewModel(
    private val pedidoUseCase: PedidoUseCase
) : ViewModel() {

    private val _estado = MutableStateFlow(false)
    val estado: StateFlow<Boolean> = _estado

    private val _pedidos = MutableStateFlow<List<Pedido>>(emptyList())
    val pedidos: StateFlow<List<Pedido>> = _pedidos

    fun crearPedido(pedido: Pedido) {
        viewModelScope.launch {
            try {
                val respuesta = pedidoUseCase.insertarPedido(pedido)

                _estado.value = true

            } catch (e: Exception) {
                e.printStackTrace()
                _estado.value = false
            }
        }
    }
    fun cargarPedidos() {
        viewModelScope.launch {
            try {
                _pedidos.value = pedidoUseCase.getPedidos()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


}