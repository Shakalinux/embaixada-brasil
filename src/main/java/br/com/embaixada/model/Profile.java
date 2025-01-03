package br.com.embaixada.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerfil;

    private String nome;

    @Lob
    private byte[] avatar;


    private String avatar64;

    private String cep;

    private String endereco;

    private String logradouro;

    private String estado;

    private String uf;

    private String telefone;

    @OneToOne(mappedBy = "profile")
    private User user;

}
