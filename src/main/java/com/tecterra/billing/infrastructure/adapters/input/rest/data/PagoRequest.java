package com.tecterra.billing.infrastructure.adapters.input.rest.data;

import com.tecterra.billing.domain.models.MetodoPago;
import com.tecterra.billing.domain.models.Plan;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class PagoRequest {

    @NotNull(message = "El ID del cliente es obligatorio")
    private Long clienteId;

    @Positive(message = "El monto debe ser mayor a cero")
    private Double monto;

    @NotNull(message = "El plan es obligatorio")
    private Plan plan;

    @NotBlank(message = "El mes de referencia no puede estar vacío")
    @Pattern(regexp = "^[a-z]{3}-\\d{2}$", message = "Formato inválido. Use ej: oct-25")
    private String mesReferencia;

    @NotNull(message = "El método de pago es obligatorio")
    private MetodoPago metodoPago;

    private String notas;

}
