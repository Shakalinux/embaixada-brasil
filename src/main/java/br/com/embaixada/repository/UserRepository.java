package br.com.embaixada.repository;

import br.com.embaixada.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByUsername(String username);

    @Query("SELECT u FROM User u " +
            "JOIN FETCH u.profile p " +
            "LEFT JOIN FETCH u.marks m " +
            "LEFT JOIN FETCH m.service s " +
            "WHERE u.email = :email")
    User findUserWithProfileAndMarksByEmail(@Param("email") String email);

}
