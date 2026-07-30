package com.example.customer_service.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequestDTO {

    private String nombre;
    private String apellidoOrazonSocial;
    private String documentoOCuit;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private String fechaAlta;
    private Double saldo;
}
