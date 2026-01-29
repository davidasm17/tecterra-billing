package com.tecterra.billing.domain.ports.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tecterra.billing.infrastructure.persistence.PagoEntity;

public interface PagoRepositoryData extends JpaRepository<PagoEntity, Long> {
    @Query(value = "SELECT SUM(monto) FROM PAGOS WHERE cliente_id = :clienteId AND mes_referencia = :mes", nativeQuery = true)
    Double sumMontoPorClienteyMes(@Param("clienteId") Long clienteId, @Param("mes") String mes);

}
