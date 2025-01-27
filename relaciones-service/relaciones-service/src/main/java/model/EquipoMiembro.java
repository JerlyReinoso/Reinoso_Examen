package model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "equipo_miembro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EquipoMiembro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long equipoId;
    private Long miembroId;
}
