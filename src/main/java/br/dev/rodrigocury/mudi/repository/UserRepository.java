package br.dev.rodrigocury.mudi.repository;

import br.dev.rodrigocury.mudi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}
