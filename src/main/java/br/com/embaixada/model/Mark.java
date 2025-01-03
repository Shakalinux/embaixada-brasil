package br.com.embaixada.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMark;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @NotNull(message = "A data é obrigatória")
    @FutureOrPresent(message = "Agendamento deve ser uma data presente ou futura!")
    @Column(nullable = false)
    private LocalDate startDate;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "idService", nullable = false)
    private Service service;
}
