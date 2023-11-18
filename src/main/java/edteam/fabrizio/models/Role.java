package edteam.fabrizio.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "role")
public class Role extends BaseEntity {

    @Getter @Setter
    @Column(name = "nombre")
    private String nombre;

    /**
     * permisos
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "role")
    @Getter @Setter
    private Set<Permiso> permisos;

}
