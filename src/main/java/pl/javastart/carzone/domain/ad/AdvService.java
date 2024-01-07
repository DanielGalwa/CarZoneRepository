package pl.javastart.carzone.domain.ad;

import org.springframework.stereotype.Service;
import pl.javastart.carzone.domain.ad.dto.AdDto;

import java.util.List;

@Service
public class AdvService {
    private final AdRepository adRepository;

    public AdvService(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    public List<AdDto> findAllAds() {
        return adRepository.findAll().stream()
                .map(AdDtoMapper::map)
                .toList();
    }
}