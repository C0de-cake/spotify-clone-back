package fr.codecake.spotifyclone.catalogcontext.application;

import fr.codecake.spotifyclone.catalogcontext.application.dto.ReadSongInfoDTO;
import fr.codecake.spotifyclone.catalogcontext.application.dto.SaveSongDTO;
import fr.codecake.spotifyclone.catalogcontext.application.mapper.SongContentMapper;
import fr.codecake.spotifyclone.catalogcontext.application.mapper.SongMapper;
import fr.codecake.spotifyclone.catalogcontext.domain.Song;
import fr.codecake.spotifyclone.catalogcontext.domain.SongContent;
import fr.codecake.spotifyclone.catalogcontext.repository.SongContentRepository;
import fr.codecake.spotifyclone.catalogcontext.repository.SongRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SongService {

    private final SongMapper songMapper;

    private final SongRepository songRepository;

    private final SongContentRepository songContentRepository;

    private final SongContentMapper songContentMapper;

    public SongService(SongMapper songMapper, SongRepository songRepository,
                       SongContentRepository songContentRepository, SongContentMapper songContentMapper) {
        this.songMapper = songMapper;
        this.songRepository = songRepository;
        this.songContentRepository = songContentRepository;
        this.songContentMapper = songContentMapper;
    }

    public ReadSongInfoDTO create(SaveSongDTO saveSongDTO) {
        Song song = songMapper.saveSongDTOToSong(saveSongDTO);
        Song songSaved = songRepository.save(song);

        SongContent songContent = songContentMapper.saveSongDTOToSong(saveSongDTO);
        songContent.setSong(songSaved);

        songContentRepository.save(songContent);
        return songMapper.songToReadSongInfoDTO(songSaved);
    }

    @Transactional(readOnly = true)
    public List<ReadSongInfoDTO> getAll() {
        return songRepository.findAll()
                .stream()
                .map(songMapper::songToReadSongInfoDTO)
                .toList();
    }
}
