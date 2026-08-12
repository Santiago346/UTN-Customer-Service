package com.example.customer_service.mapper;

import com.example.customer_service.dtos.CustomerDTO;
import com.example.customer_service.dtos.CustomerRequestDTO;
import com.example.customer_service.dtos.CustomerSaldoDTO;
import com.example.customer_service.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public CustomerDTO toResponse(Customer customer) {

        CustomerDTO response = new CustomerDTO();

        response.setId(customer.getId());
        response.setNombre(customer.getNombre());
        response.setApellidoOrazonSocial(customer.getApellidoOrazonSocial());
        response.setDocumentoOCuit(customer.getDocumentoOCuit());
        response.setDireccion(customer.getDireccion());
        response.setTelefono(customer.getTelefono());
        response.setCorreoElectronico(customer.getCorreoElectronico());
        response.setFechaAlta(customer.getFechaAlta());

        return response;
    }

    public Customer toEntity(CustomerRequestDTO request) {

        Customer customer = new Customer();

        customer.setNombre(request.getNombre());
        customer.setApellidoOrazonSocial(request.getApellidoOrazonSocial());
        customer.setDocumentoOCuit(request.getDocumentoOCuit());
        customer.setDireccion(request.getDireccion());
        customer.setTelefono(request.getTelefono());
        customer.setCorreoElectronico(request.getCorreoElectronico());
        customer.setFechaAlta(request.getFechaAlta());
        customer.setSaldo(request.getSaldo());

        return customer;
    }

    public CustomerSaldoDTO toSaldoResponse(Customer customer) {
        CustomerSaldoDTO response = new CustomerSaldoDTO();
        response.setId(customer.getId());
        response.setSaldo(customer.getSaldo());
        return response;
    }
}
