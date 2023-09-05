package com.example.tppersistencia.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario extends EntidadBase {
    private String nombre;
    private String password;
    private String rol;

    // Revisar: orphanRemoval = true (si eliminamos un usuario, no deberían borrarse su pedidos).
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuarioId")
    List<Pedido> pedidos;
}
