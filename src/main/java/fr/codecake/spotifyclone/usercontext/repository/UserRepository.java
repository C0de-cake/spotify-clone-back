package fr.codecake.spotifyclone.usercontext.repository;

import fr.codecake.spotifyclone.usercontext.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByEmail(String email);

}
