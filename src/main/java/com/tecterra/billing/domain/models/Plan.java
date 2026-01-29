package com.tecterra.billing.domain.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Plan {
    WISP_10MB(250.0, "Internet Inalambrico 10 Megas"),
    WISP_15MB(350.0, "Internet Inalambrico 15 Megas"),
    WISP_20MB(450.0, "Internet Inalambrico 20 Megas");

    private final double precio;
    private final String descripcion;

}
