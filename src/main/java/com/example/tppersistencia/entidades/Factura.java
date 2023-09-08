package com.example.tppersistencia.entidades;

import com.example.tppersistencia.utils.FormaPago;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Factura extends EntidadBase {

    private String fecha;
    private int numero;
    private Double descuento;

    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;

    private int total;
}
