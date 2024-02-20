package fr.codecake.spotifyclone.usercontext.repository;

import fr.codecake.spotifyclone.usercontext.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
