# Tecterra - Billing & Network Service
Microservicio encargado de la gestión financiera y control de acceso a red.

## Arquitectura
- **Patrón:** Arquitectura Hexagonal (Ports & Adapters).
- **Core:** Java 17 + Spring Boot.
- **Base de Datos:** Oracle XE.
- **Integración:** Mikrotik API.

## Cómo ejecutar
1. Clonar el repositorio.
2. Configurar el `application.yml` con tus credenciales de Oracle.
3. Ejecutar `./mvnw spring-boot:run`.