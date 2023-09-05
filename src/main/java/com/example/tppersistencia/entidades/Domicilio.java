package com.example.tppersistencia.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Domicilio extends EntidadBase {
    private String calle;
    private String numero;
    private String localidad;

    @OneToMany
    @JoinColumn(name = "domicilioId")
    private List<Pedido> pedidos;

    @ManyToOne
    @JoinColumn(name = "clienteId")
    private Cliente cliente;
}
