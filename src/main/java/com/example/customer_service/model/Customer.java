package com.example.customer_service.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
public class Customer {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nombre;
        private String apellidoOrazonSocial;
        private String documentoOCuit;
        private String direccion;
        private String telefono;
        private String correoElectronico;
        private String fechaAlta;
        private Double saldo;

}
