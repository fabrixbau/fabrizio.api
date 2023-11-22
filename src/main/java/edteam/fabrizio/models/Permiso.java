package edteam.fabrizio.models;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "permisos")
@NoArgsConstructor
@AllArgsConstructor
public class Permiso extends BaseEntity {

    @Column(name = "nombre")
    @Getter @Setter
    private String nombre;

    /**
     * Role
     */
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("role_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    @Getter @Setter
    private Role role;

    @Override
    public String toString() {
        return "Permiso{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Permiso permiso)) return false;
        return Objects.equals(getNombre(), permiso.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombre());
    }
}


