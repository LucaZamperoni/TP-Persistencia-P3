package com.example.tppersistencia.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetallePedido extends EntidadBase {

    private int cantidad;
    private Double subtotal;

    @ManyToOne
    @JoinColumn(name = "detallePedidoId")
    private Producto producto;
}
