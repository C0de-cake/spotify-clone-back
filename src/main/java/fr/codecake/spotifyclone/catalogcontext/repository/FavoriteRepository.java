package fr.codecake.spotifyclone.catalogcontext.repository;

import fr.codecake.spotifyclone.catalogcontext.domain.Favorite;
import fr.codecake.spotifyclone.catalogcontext.domain.FavoriteId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, FavoriteId> {
}
