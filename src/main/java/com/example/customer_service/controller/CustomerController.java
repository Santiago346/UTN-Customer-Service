package com.example.customer_service.controller;

import com.example.customer_service.dtos.CustomerDTO;
import com.example.customer_service.dtos.CustomerRequestDTO;
import com.example.customer_service.dtos.CustomerSaldoDTO;
import com.example.customer_service.dtos.ProductDTO;
import com.example.customer_service.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService customerService) {
        this.service = customerService;
    }

    @GetMapping
    public List<CustomerDTO> getCustomers() {
        return service.getCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDTO getCustomerById(@PathVariable Long id) {
        return service.getCustomerById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO addCustomer(@RequestBody CustomerRequestDTO request) {
        return service.addCustomer(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
    }

    @PutMapping("/{id}")
    public CustomerDTO updateCustomer(@PathVariable Long id, @RequestBody CustomerRequestDTO request) {
        return service.updateCustomer(id, request);
    }

    @GetMapping("/{id}/saldo")
    public CustomerSaldoDTO getSaldoCliente(@PathVariable Long id) {
        return service.getSaldoCliente(id);
    }

    @GetMapping("/{id}/productos")
    public List<ProductDTO> getProductosDeCliente(@PathVariable Long id) {
        return service.getProductosDeCliente(id);
    }
}
