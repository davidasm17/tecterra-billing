package com.tecterra.billing.domain.models;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Pago {
    private Long id;
    private Long clienteId;
    private double monto;
    private String mesReferencia;
    private LocalDate fechaPago;
    private String metodoPago;
    private String notas;
}
