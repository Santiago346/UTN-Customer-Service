package com.example.customer_service.client;

import com.example.customer_service.dtos.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service")
public interface ProductClient {

    @GetMapping("/productos")
    List<ProductDTO> getProductos();

    @GetMapping("/productos/{id}")
    ProductDTO getProductoById(@PathVariable Long id);

    @GetMapping("/productos/cliente/{clienteId}")
    List<ProductDTO> getProductosByClienteId(@PathVariable Long clienteId);
}
