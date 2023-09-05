package com.example.tppersistencia.entidades;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pedido extends EntidadBase {

    private String fecha;
    private String estado; // (Iniciado - Preparacion - Entregado)
    private String horaEstimadaEntrega;
    private String tipoEnvio; // (Delivery - Retira)
    private Double total;

    @OneToOne
    @JoinColumn(name = "facturaId")
    private Factura factura;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "pedidoId")
    private List<DetallePedido> detallesPedidos;
}
