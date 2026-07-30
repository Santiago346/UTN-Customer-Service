package com.example.customer_service.exceptions;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(Long id) {
        super("Cliente no encontrado con id: " + id);
    }
}
