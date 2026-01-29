package com.tecterra.billing.infrastructure.adapters.input.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tecterra.billing.domain.models.Pago;
import com.tecterra.billing.domain.ports.in.CasoUsoRegistrarPago;
import com.tecterra.billing.infrastructure.adapters.input.rest.data.PagoRequest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/pagos")
@RequiredArgsConstructor
public class PagoController {
    private final CasoUsoRegistrarPago registrarPago;

    @PostMapping
    public ResponseEntity<String> registrarPago(@Valid @RequestBody PagoRequest request) {
        log.info("Entrando al Controller");
        log.info("Registrando pago para el cliente: {}", request.getClienteId());

        Double costoPlan = request.getPlan().getPrecio();
        String descripcionPlan = request.getPlan().getDescripcion();
        Pago pago = new Pago();
        pago.setClienteId(request.getClienteId());
        pago.setMonto(request.getMonto());
        pago.setMesReferencia(request.getMesReferencia());
        pago.setMetodoPago(request.getMetodoPago());
        pago.setNotas(request.getNotas());
        registrarPago.ejecutar(pago);
        log.info("Pago registrado exitosamente");
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(String.format("Pago de $%.2f recibido para el plan %s (%s)",
                        request.getMonto(),
                        request.getPlan().getDescripcion(),
                        request.getPlan().getPrecio()));
    }

}
