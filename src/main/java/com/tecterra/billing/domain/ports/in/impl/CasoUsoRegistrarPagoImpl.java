package com.tecterra.billing.domain.ports.in.impl;

import com.tecterra.billing.domain.ports.out.PagoRepositoryPort;
import com.tecterra.billing.domain.ports.out.PortMikrotik;

public class CasoUsoRegistrarPagoImpl implements CasoUsoRegistrarPago {
     private final PagoRepositoryPort pagoRepositoryPort;
    private final PortMikrotik portMikrotik;
    private final ClienteRepositoryPort clienteRepositoryPort;

    @Override
    @Transactional
    public void ejecutar(Pago pago) {
        // 1. Guardar el pago en Oracle
        pagoRepository.guardar(pago);

        // 2. Obtener datos del cliente (necesitamos su IP para el MikroTik)
        Cliente cliente = clienteRepository.buscarPorId(pago.getClienteId());

        // 3. Lógica de Activación: Si el monto es igual o mayor al costo del plan
        // Nota: En un entorno real compararías contra el saldo pendiente
        if (pago.getMonto() >= pago.getPlan().getCosto()) {
            mikrotikPort.activarAcceso(cliente.getIpAddress(), cliente.getNombre());
        }
    }

}
