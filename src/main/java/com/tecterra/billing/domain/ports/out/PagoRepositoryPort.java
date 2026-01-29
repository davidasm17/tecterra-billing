package com.tecterra.billing.domain.ports.out;

import java.util.List;

import com.tecterra.billing.domain.models.Pago;

public interface PagoRepositoryPort {
    Pago guardar(Pago pago);

    List<Pago> buscarPorCliente(Long clienteId);

    Double sumarPagosDelMes(Long clienteId, String mes);

}
