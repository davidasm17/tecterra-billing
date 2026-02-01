package com.tecterra.billing.domain.ports.out;

public interface PortMikrotik {
	void activarAcceso(String ipAddress, String nombreCliente);

	void suspenderAcceso(String ipAddress, String nombreCliente);
}
