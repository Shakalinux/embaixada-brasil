package br.com.embaixada.repository;

import br.com.embaixada.model.Mark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarkRepository extends JpaRepository<Mark, Long> {
}
