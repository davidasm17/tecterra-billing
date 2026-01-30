package com.tecterra.billing.application.usecases;

import org.springframework.stereotype.Service;

import com.tecterra.billing.domain.models.Pago;
import com.tecterra.billing.domain.ports.in.CasoUsoRegistrarPago;
import com.tecterra.billing.domain.ports.out.PagoRepositoryPort;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegistrarPagoService implements CasoUsoRegistrarPago {
    private final PagoRepositoryPort pagoRepositoryPort;

    @Override
    @Transactional
    public void ejecutar(Pago pago) {
        pagoRepositoryPort.guardar(pago);

        Double totalPagado = pagoRepositoryPort.sumarPagosDelMes(pago.getClienteId(), pago.getMesReferencia());

        Double costoPlan = 350.0;

        if (totalPagado >= costoPlan) {
            log.info("Cliente {} ha pagado su plan completo", pago.getClienteId());
            log.info("Enviando señal a MikroTik para activar servicio");
        } else {
            log.info("Pago parcial recibido. Saldo restante: {}", costoPlan - totalPagado);
        }
    }

}
