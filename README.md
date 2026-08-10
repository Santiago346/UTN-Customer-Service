# Customer Service

Microservicio encargado de gestionar los clientes del banco. Se comunica con `product-service` vía Feign (a través de Eureka) para consultar los productos asociados a un cliente. Forma parte de una arquitectura de microservicios coordinada por un Eureka Server y un Config Server.

## Stack

- Spring Boot
- Spring Data JPA + H2 (base de datos en memoria)
- Spring Cloud Config Client
- Spring Cloud Netflix Eureka Client
- Spring Cloud OpenFeign

## Configuración

La configuración de puerto, datasource y Eureka se obtiene del **Config Server** (archivo `customer-service.yaml` en `config-repo/`). El `application.yaml` local solo define lo mínimo:

```yaml
spring:
  application:
    name: customer-service
  config:
    import: configserver:http://localhost:8888
```

## Modelo de datos

`Customer`: id, nombre, apellidoOrazonSocial, documentoOCuit, direccion, telefono, correoElectronico, fechaAlta, saldo.

## Comunicación con product-service

Vía `ProductClient` (interfaz `@FeignClient(name = "product-service")`).

## Endpoints

| Método | Endpoint | Descripción |
|---|---|---|
| GET | `/clientes` | Lista todos los clientes |
| GET | `/clientes/{id}` | Obtiene un cliente por id |
| POST | `/clientes` | Crea un cliente nuevo |
| DELETE | `/clientes/{id}` | Elimina un cliente |
| GET | `/clientes/{id}/productos` | Lista los productos del cliente (vía Feign a product-service) |

### Ejemplo — POST /clientes

```json
{
  "nombre": "Carlos",
  "apellidoOrazonSocial": "Rodríguez",
  "documentoOCuit": "20345678901",
  "direccion": "Belgrano 789",
  "telefono": "1155667788",
  "correoElectronico": "carlos.rodriguez@mail.com",
  "fechaAlta": "2026-07-25",
  "saldo": 300000
}
```

## Cómo correrlo

Requiere que **Eureka Server**, **Config Server** y (para el endpoint de productos) **product-service** estén corriendo previamente.

```bash
mvn spring-boot:run
```

El servicio levanta en el puerto **8081** (definido en el Config Server) y se registra automáticamente en Eureka.

## Datos de prueba

El proyecto incluye un `DataLoader` (`CommandLineRunner`) que precarga clientes de ejemplo en la base H2 al arrancar.