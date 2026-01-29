package com.tecterra.billing.domain.models;

import java.util.List;

public class Cliente {
    private Long id;
    private String nombre;
    private String ipAddress;
    private String estado;
    private Plan plan;

    public boolean tienePermisoDeAcceso(Double saldoPendiente) {
        return saldoPendiente <= 0;
    }

}
