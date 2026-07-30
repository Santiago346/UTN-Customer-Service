package com.example.customer_service.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
    private Long id;
    private String nombre;
    private String apellidoOrazonSocial;
    private String documentoOCuit;
    private String direccion;
    private String telefono;
    private String correoElectronico;
    private String fechaAlta;
}
