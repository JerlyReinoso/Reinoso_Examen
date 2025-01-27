package model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "miembros")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Miembro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
}
