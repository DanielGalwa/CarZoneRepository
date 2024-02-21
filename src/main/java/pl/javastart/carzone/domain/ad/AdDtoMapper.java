package pl.javastart.carzone.domain.ad;

import pl.javastart.carzone.domain.ad.dto.AdDto;

public class AdDtoMapper {
    public static AdDto map(Ad ad) {
        return new AdDto(ad.getId(), ad.getVehicleBrand(),
                ad.getVehicleModel(), ad.getPrice(), ad.getEngineSize(),
                ad.getPower(), ad.getMileage(), ad.getFuelType(),
                ad.getGear(), ad.getYearOfProduction(), ad.getLocation(),
                ad.getSeller(),ad.getPicture());
    }
}
