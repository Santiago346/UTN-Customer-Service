package com.example.customer_service.dtos;

import com.example.customer_service.model.ProductType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDTO {
    private Long id;
    private Long clienteId;
    private ProductType tipo;
    private String nombre;
    private String descripcion;
    private boolean activo;
}
