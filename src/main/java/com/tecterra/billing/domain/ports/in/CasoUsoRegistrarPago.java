package com.tecterra.billing.domain.ports.in;

import com.tecterra.billing.domain.models.Pago;

public interface CasoUsoRegistrarPago {
    void ejecutar(Pago pago);

}
