package pl.javastart.carzone.domain.ad;

import org.springframework.stereotype.Service;
import pl.javastart.carzone.domain.ad.dto.AdDto;
import pl.javastart.carzone.storage.FileStorageService;

import java.util.List;
import java.util.Optional;

@Service
public class AdvService {
    private final AdRepository adRepository;
    private final FileStorageService fileStorageService;

    public AdvService(AdRepository adRepository, FileStorageService fileStorageService) {
        this.adRepository = adRepository;
        this.fileStorageService = fileStorageService;
    }

    public List<AdDto> findAllAds() {
        return adRepository.findAll().stream()
                .map(AdDtoMapper::map)
                .toList();
    }
    public Optional<AdDto> findAdById(long id){
        return adRepository.findById(id).map(AdDtoMapper::map);
    }
/*    public void addMovie(MovieSaveDto movieToSave) {
        Movie movie = new Movie();
        movie.setTitle(movieToSave.getTitle());
        movie.setOriginalTitle(movieToSave.getOriginalTitle());
        movie.setPromoted(movieToSave.isPromoted());
        movie.setReleaseYear(movieToSave.getReleaseYear());
        movie.setShortDescription(movieToSave.getShortDescription());
        movie.setDescription(movieToSave.getDescription());
        movie.setYoutubeTrailerId(movieToSave.getYoutubeTrailerId());
        Genre genre = genreRepository.findByNameIgnoreCase(movieToSave.getGenre()).orElseThrow();
        movie.setGenre(genre);
        if (movieToSave.getPoster() != null && !movieToSave.getPoster().isEmpty()) {
            String savedFileName = fileStorageService.saveImage(movieToSave.getPoster());
            movie.setPoster(savedFileName);
        }
        movieRepository.save(movie);
    }*/
}