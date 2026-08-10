package com.example.customer_service.service;

import com.example.customer_service.client.ProductClient;
import com.example.customer_service.dtos.CustomerDTO;
import com.example.customer_service.dtos.CustomerRequestDTO;
import com.example.customer_service.dtos.CustomerSaldoDTO;
import com.example.customer_service.dtos.ProductDTO;
import com.example.customer_service.exceptions.CustomerNotFoundException;
import com.example.customer_service.mapper.CustomerMapper;
import com.example.customer_service.model.Customer;
import com.example.customer_service.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final ProductClient productClient;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper, ProductClient productClient) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
        this.productClient = productClient;
    }

    public List<CustomerDTO> getCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toResponse)
                .toList();
    }

    public CustomerDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        return customerMapper.toResponse(customer);
    }

    public CustomerDTO addCustomer(CustomerRequestDTO request) {
        Customer customer = customerMapper.toEntity(request);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.toResponse(savedCustomer);
    }

    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new CustomerNotFoundException(id);
        }
        customerRepository.deleteById(id);
    }

    public CustomerDTO updateCustomer(Long id, CustomerRequestDTO request) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() ->
                        new CustomerNotFoundException(id)
                );

        customer.setNombre(request.getNombre());
        customer.setApellidoOrazonSocial(request.getApellidoOrazonSocial());
        customer.setDireccion(request.getDireccion());
        customer.setTelefono(request.getTelefono());
        customer.setCorreoElectronico(request.getCorreoElectronico());

        Customer updatedCustomer = customerRepository.save(customer);

        return customerMapper.toResponse(updatedCustomer);
    }

    public CustomerSaldoDTO getSaldoCliente(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() ->
                        new CustomerNotFoundException(id)
                );
        return customerMapper.toSaldoResponse(customer);
    }

    public List<ProductDTO> getProductosDeCliente(Long clienteId) {
        if (!customerRepository.existsById(clienteId)) {
            throw new CustomerNotFoundException(clienteId);
        }
        return productClient.getProductosByClienteId(clienteId);
    }
}
