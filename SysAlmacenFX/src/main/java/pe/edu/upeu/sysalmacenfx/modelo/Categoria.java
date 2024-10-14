package pe.edu.upeu.sysalmacenfx.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.upeu.sysalmacenfx.servicio.ClienteService;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "upeu_categoria")
public class Categoria extends ClienteService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;
    @Column(name = "nombre", nullable = false, length = 60)
    private String nombre;

}

