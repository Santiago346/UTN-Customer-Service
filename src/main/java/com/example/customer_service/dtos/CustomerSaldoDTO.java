package com.example.customer_service.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CustomerSaldoDTO {
    private Long id;
    private BigDecimal saldo;
}
