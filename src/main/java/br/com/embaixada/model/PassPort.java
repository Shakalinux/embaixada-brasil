package br.com.embaixada.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class PassPort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PassportStatus status;

    public PassPort(User user, PassportStatus status) {
        this.user = user;
        this.status = PassportStatus.BLOQUEADO;
    }
}
