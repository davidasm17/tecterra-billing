package com.tecterra.billing.infrastructure.persistence;

import java.time.LocalDate;

import com.tecterra.billing.domain.models.MetodoPago;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "PAGOS")
@Data
public class PagoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pago_seq")
    @SequenceGenerator(name = "pago_seq", sequenceName = "SEQ_PAGOS", allocationSize = 1)
    private Long id;

    @Column(name = "CLIENTE_ID", nullable = false)
    private Long clienteId;

    @Column(name = "MONTO")
    private Double monto;

    @Column(name = "MES_REFERENCIA", length = 10)
    private String mesReferencia;

    @Column(name = "FECHA_PAGO")
    private LocalDate fechaPago;

    @Column(name = "METODO_PAGO", length = 30)
    @Enumerated(EnumType.STRING)
    private MetodoPago metodoPago;

    @Column(name = "NOTAS", length = 255)
    private String notas;
}
