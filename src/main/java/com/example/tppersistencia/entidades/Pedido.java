package com.example.tppersistencia.entidades;

import java.util.List;

import com.example.tppersistencia.utils.Estado;
import com.example.tppersistencia.utils.TipoEnvio;
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

    @Enumerated(EnumType.STRING)
    private Estado estado;

    private String horaEstimadaEntrega;

    @Enumerated(EnumType.STRING)
    private TipoEnvio tipoEnvio;

    private Double total;

    @OneToOne
    @JoinColumn(name = "facturaId")
    private Factura factura;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "pedidoId")
    private List<DetallePedido> detallesPedidos;
}
