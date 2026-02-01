package com.tecterra.billing.infrastructure.adapters.output.rest;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "mikrotik", url = "${mikrotik.url}")
public interface MikrotikClient {

    @PatchMapping("/rest/ip/firewall/address-list/{id}")
    void actualizarEstado(@PathVariable("id") String id, @RequestBody String body);

    @PostMapping("/rest/ip/firewall/address-list")
    void agregarALista(@RequestBody Map<String, Object> body);
}