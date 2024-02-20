package fr.codecake.spotifyclone.catalogcontext.repository;

import fr.codecake.spotifyclone.catalogcontext.domain.SongContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongContentRepository extends JpaRepository<SongContent, Long> {
}
