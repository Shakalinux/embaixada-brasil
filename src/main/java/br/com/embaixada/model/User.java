package br.com.embaixada.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    @NotBlank(message = "nome é obrigatório!")
    private String username;

    @Email(message = "Email inválido!")
    @NotBlank(message = "Email é obrigatório")
    private String email;

    @NotBlank(message = "Senha é obrigatória!")
    private String password;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "idPerfil", referencedColumnName = "idPerfil")
    private Profile profile;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mark> marks = new ArrayList<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private PassPort passport;

    @Override
    public String toString() {
        return "User{" +
                "idUsuario=" + idUsuario +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", profile=" + profile +
                ", marks=" + marks +
                ", passport=" + passport +
                '}';
    }
}
