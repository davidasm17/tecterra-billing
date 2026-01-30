package com.tecterra.billing.domain.ports.out;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.tecterra.billing.domain.models.Pago;
import com.tecterra.billing.infrastructure.persistence.PagoEntity;
import com.tecterra.billing.infrastructure.persistence.PagoMapper;
import com.tecterra.billing.infrastructure.persistence.repositories.PagoRepositoryData;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PagoAdapter implements PagoRepositoryPort {
    private final PagoRepositoryData pagoRepository;
    private final PagoMapper pagoMapper;

    @Override
    public Pago guardar(Pago pago) {
        PagoEntity entity = pagoMapper.toEntity(pago);
        return pagoMapper.toDomain(pagoRepository.save(entity));
    }

    @Override
    public List<Pago> buscarPorCliente(Long clienteId) {
        return pagoRepository.findById(clienteId)
                .stream()
                .map(pagoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Double sumarPagosDelMes(Long clienteId, String mes) {
        Double total = pagoRepository.sumMontoPorClienteyMes(clienteId, mes);
        return total != null ? total : 0.0;
    }

}
