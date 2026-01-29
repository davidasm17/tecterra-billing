package com.tecterra.billing.infrastructure.persistence;

import org.mapstruct.Mapper;

import com.tecterra.billing.domain.models.Pago;

@Mapper(componentModel = "spring")
public interface PagoMapper {
    PagoEntity toEntity(Pago domain);

    Pago toDomain(PagoEntity entity);

}
