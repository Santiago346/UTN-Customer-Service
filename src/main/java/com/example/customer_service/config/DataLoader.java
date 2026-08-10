package com.example.customer_service.config;

import com.example.customer_service.model.Customer;
import com.example.customer_service.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(CustomerRepository repository) {

        return args -> {

            Customer c1 = new Customer();
            c1.setNombre("Juan");
            c1.setApellidoOrazonSocial("Pérez");
            c1.setDocumentoOCuit("30123456789");
            c1.setDireccion("Av. Siempre Viva 123");
            c1.setTelefono("1122334455");
            c1.setCorreoElectronico("juan.perez@mail.com");
            c1.setFechaAlta(LocalDate.of(2026, 1, 15));
            c1.setSaldo(new BigDecimal("150000"));
            repository.save(c1);

            Customer c2 = new Customer();
            c2.setNombre("María");
            c2.setApellidoOrazonSocial("González");
            c2.setDocumentoOCuit("27234567890");
            c2.setDireccion("Calle Falsa 456");
            c2.setTelefono("1133445566");
            c2.setCorreoElectronico("maria.gonzalez@mail.com");
            c2.setFechaAlta(LocalDate.of(2026, 2, 20));
            c2.setSaldo(new BigDecimal("500000"));
            repository.save(c2);

            Customer c3 = new Customer();
            c3.setNombre("Empresa XYZ");
            c3.setApellidoOrazonSocial("S.A.");
            c3.setDocumentoOCuit("30987654321");
            c3.setDireccion("Ruta 8 Km 45");
            c3.setTelefono("1144556677");
            c3.setCorreoElectronico("contacto@xyz.com");
            c3.setFechaAlta(LocalDate.of(2026, 3, 10));
            c3.setSaldo(new BigDecimal("2000000"));
            repository.save(c3);

        };
    }
}
