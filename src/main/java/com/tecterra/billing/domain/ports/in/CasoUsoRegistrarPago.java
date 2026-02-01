package com.tecterra.billing.domain.ports.in;

import com.tecterra.billing.domain.models.Pago;
import com.tecterra.billing.domain.ports.out.PagoRepositoryPort;

public interface CasoUsoRegistrarPago {
   
    void ejecutar(Pago pago);

}
