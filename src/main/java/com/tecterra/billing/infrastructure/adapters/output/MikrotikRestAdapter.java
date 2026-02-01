package com.tecterra.billing.infrastructure.adapters.output;

import com.tecterra.billing.domain.ports.out.PortMikrotik;
import com.tecterra.billing.infrastructure.adapters.output.rest.MikrotikClient;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MikrotikRestAdapter implements PortMikrotik {

    private final MikrotikClient client;

    @Override
    public void activarAcceso(String ipAddress) {
        // Ejemplo: Cambiar el comentario o mover de Address List
        String body = "{\"comment\": \"ACTIVO - Pago Tecterra\"}";
        client.actualizarEstado(ipAddress, body);
    }

    @Override
    public void suspenderAcceso(String ipAddress) {
        String body = "{\"comment\": \"SUSPENDIDO - Falta de pago\"}";
        client.actualizarEstado(ipAddress, body);
    }
}