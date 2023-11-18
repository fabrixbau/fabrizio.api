package edteam.fabrizio.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User extends BaseEntity {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="role_id")

    @Getter @Setter
    private Role role;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @Getter
    @Setter
    @Column(name = "nombre")
    private String nombre;

    @Getter @Setter
    @Column(name = "apellido")
    private String apellido;

    @Getter @Setter
    @Column(name = "email")
    private String email;

    @Getter @Setter
    @Column(name = "telefono")
    private String telefono;

    @Getter @Setter
    @Column(name = "fechaNac")
    private Date fechaNac;

}
