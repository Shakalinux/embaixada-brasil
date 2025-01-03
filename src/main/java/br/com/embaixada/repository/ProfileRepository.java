package br.com.embaixada.repository;

import br.com.embaixada.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Profile findByUserUsername(String username);
}
