package com.example.tppersistencia.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente extends EntidadBase {

    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    @OneToMany
    @JoinColumn(name = "clienteId")
    private List<Pedido> pedidos;
}
