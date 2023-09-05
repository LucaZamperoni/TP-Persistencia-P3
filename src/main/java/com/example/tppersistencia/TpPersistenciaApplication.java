package com.example.tppersistencia;

import com.example.tppersistencia.repositorios.*;
import com.example.tppersistencia.entidades.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class TpPersistenciaApplication {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    FacturaRepository facturaRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    DomicilioRepository domicilioRepository;

    @Autowired
    RubroRepository rubroRepository;

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    DetallePedidoRepository detallePedidoRepository;

    public static void main(String[] args) {
        SpringApplication.run(TpPersistenciaApplication.class, args);
    }

    @Bean
    CommandLineRunner init() {
        return args -> {

            Factura factura1 = Factura.builder().fecha("12/6/2003").numero(1).descuento(0.6).formaPago("efectivo").total(1000).build();
            Factura factura2 = Factura.builder().fecha("12/7/2003").numero(2).descuento(0.6).formaPago("efectivo").total(1250).build();
            Factura factura3 = Factura.builder().fecha("12/8/2003").numero(3).descuento(0.6).formaPago("efectivo").total(2000).build();

            Pedido pedido1 = Pedido.builder().fecha("11/7/2004").estado("Pendiente").horaEstimadaEntrega("13:30").tipoEnvio("Delivery").total(2000d).factura(factura1).build();
            Pedido pedido2 = Pedido.builder().fecha("11/8/2004").estado("Pendiente").horaEstimadaEntrega("13:30").tipoEnvio("Retira").total(2000d).factura(factura2).build();
            Pedido pedido3 = Pedido.builder().fecha("11/9/2004").estado("Pendiente").horaEstimadaEntrega("13:30").tipoEnvio("Delivery").total(2000d).factura(factura3).build();
            List<Pedido> pedidos = new ArrayList<>();
            pedidos.add(pedido1);
            pedidos.add(pedido2);
            pedidos.add(pedido3);

            Usuario usuario = Usuario.builder().nombre("Luca").password("12345").rol("Usuario").pedidos(pedidos).build();

            // Persistir los objetos:
            facturaRepository.save(factura1);
            facturaRepository.save(factura2);
            facturaRepository.save(factura3);

            pedidoRepository.save(pedido1);
            pedidoRepository.save(pedido2);
            pedidoRepository.save(pedido3);

            usuarioRepository.save(usuario);

            Cliente cliente = Cliente.builder().nombre("Facundo").apellido("Sarasa").telefono("261557649").email("facu@gmail.com").pedidos(pedidos).build();

            Domicilio domicilio = Domicilio.builder().calle("Las palmas").numero("4532").localidad("Santa Teresa").pedidos(pedidos).cliente(cliente).build();

            Rubro rubro = Rubro.builder().denominacion("Ejemplo").build();

            Producto producto = Producto.builder().tipo("A").tiempoEstimadoCocina(2).denominacion("...").precioVenta(2000d).precioCompra(1000d).stockActual(4).stockMinimo(1).unidadMedida("cm").foto("No hay foto aún").receta("...").rubro(rubro).build();

            DetallePedido detallePedido = DetallePedido.builder().cantidad(2).subtotal(2300d).producto(producto).build();

            // Persistir los objetos:
            clienteRepository.save(cliente);
            domicilioRepository.save(domicilio);
            rubroRepository.save(rubro);
            productoRepository.save(producto);
            detallePedidoRepository.save(detallePedido);

            // Pruebas de recuperación de datos.
            try {
                Optional<Pedido> pedido1Opcional = pedidoRepository.findById(pedido1.getId());
                if (pedido1Opcional.isPresent()) {
                    Pedido pedido1Recuperado = pedido1Opcional.get();
                    System.out.println(pedido1Recuperado);
                }
            } catch (Exception e) {
                System.out.println("Error en PEDIDO");
                System.out.println(e.getMessage());
            }

            try {
                Optional<Usuario> usuarioOpcional = usuarioRepository.findById(pedido1.getId());
                if (usuarioOpcional.isPresent()) {
                    Usuario usuarioRecuperado = usuarioOpcional.get();
                    System.out.println(usuarioRecuperado);

                }
            } catch (Exception e) {
                System.out.println("Error en USUARIO");
                System.out.println(e.getMessage());
            }
        };
    }
}
