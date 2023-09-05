package com.example.tppersistencia.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rubro extends EntidadBase {
    private String denominacion;

    @OneToMany(fetch = FetchType.EAGER)
    List<Producto> productos;
}
