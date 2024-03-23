package pl.javastart.carzone.domain.ad;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.javastart.carzone.domain.ad.dto.AdDto;
import pl.javastart.carzone.domain.ad.dto.AdSaveDto;
import pl.javastart.carzone.storage.FileStorageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class AdService {
    private final AdRepository adRepository;
    private final FileStorageService fileStorageService;

    public AdService(AdRepository adRepository, FileStorageService fileStorageService) {
        this.adRepository = adRepository;
        this.fileStorageService = fileStorageService;
    }
    public Page<AdDto> findAllAds(Pageable pageable) {
        return adRepository.findAll(pageable).map(AdDtoMapper::map);
    }

    public Page<AdDto> findAdsByCriteria(String model, String brand, Pageable pageable) {
        Specification<Ad> spec = AdSpecification.withDynamicQuery(model, brand);
        return adRepository.findAll(spec, pageable).map(AdDtoMapper::map);
    }

    public Optional<AdDto> findAdById(long id){
        return adRepository.findById(id).map(AdDtoMapper::map);
    }

    public void addAd(AdSaveDto adToSave) {
        Ad ad = new Ad();
        ad.setVehicleBrand(adToSave.getVehicleBrand());
        ad.setVehicleModel(adToSave.getVehicleModel());
        ad.setPrice(adToSave.getPrice());
        ad.setEngineSize(adToSave.getEngineSize());
        ad.setPower(adToSave.getPower());
        ad.setMileage(adToSave.getMileage());
        ad.setFuelType(adToSave.getFuelType());
        ad.setGear(adToSave.getGear());
        ad.setYearOfProduction(adToSave.getYearOfProduction());
        ad.setLocation(adToSave.getLocation());
        ad.setSeller(adToSave.getSeller());

        if (adToSave.getPicture() != null && !adToSave.getPicture().isEmpty()) {
            String savedFileName = fileStorageService.saveImage(adToSave.getPicture());
            ad.setPicture(savedFileName);
        }
        adRepository.save(ad);
    }

}