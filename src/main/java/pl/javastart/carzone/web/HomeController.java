package pl.javastart.carzone.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.javastart.carzone.domain.ad.dto.AdDto;
import pl.javastart.carzone.domain.ad.AdService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Page;
import pl.javastart.carzone.domain.ad.enums.*;

@Controller
public class HomeController {
    private final AdService adService;

    public HomeController(AdService adService) {
        this.adService = adService;
    }

    @GetMapping("/")
    String home(Model model, @PageableDefault(size = 5) Pageable pageable,
                @RequestParam(required = false) String vehicleModel,
                @RequestParam(required = false) String vehicleBrand,
                @RequestParam(required = false) String bodyType,
                @RequestParam(required = false) String gearBox,
                @RequestParam(required = false) String fuel,
                @RequestParam(required = false) Integer priceFrom,
                @RequestParam(required = false) Integer priceTo,
                @RequestParam(required = false) Integer mileageFrom,
                @RequestParam(required = false) Integer mileageTo,
                @RequestParam(required = false) Integer powerFrom,
                @RequestParam(required = false) Integer powerTo,
                @RequestParam(required = false) Integer engineSizeFrom,
                @RequestParam(required = false) Integer engineSizeTo,
                @RequestParam(required = false) String location){

        Page<AdDto> adsPage = adService.findAdsByCriteria(vehicleModel, vehicleBrand, bodyType, gearBox, fuel,
                priceFrom, priceTo, mileageFrom, mileageTo, powerFrom, powerTo, engineSizeFrom, engineSizeTo,
                location, pageable);

        model.addAttribute("vehicleModel",vehicleModel);
        model.addAttribute("models", VehicleModel.values());

        model.addAttribute("vehicleBrand",vehicleBrand);
        model.addAttribute("brands", Brand.values());

        model.addAttribute("bodyType",bodyType);
        model.addAttribute("bodyTypes", BodyType.values());

        model.addAttribute("gearBox",gearBox);
        model.addAttribute("gearBoxTypes", Gearbox.values());

        model.addAttribute("fuel",fuel);
        model.addAttribute("fuelTypes", Fuel.values());

        model.addAttribute("priceFrom",priceFrom);
        model.addAttribute("priceTo",priceTo);

        model.addAttribute("mileageFrom", mileageFrom);
        model.addAttribute("mileageTo", mileageTo);

        model.addAttribute("powerFrom", powerFrom);
        model.addAttribute("powerTo", powerTo);

        model.addAttribute("engineSizeFrom", engineSizeFrom);
        model.addAttribute("engineSizeTo", engineSizeTo);

        model.addAttribute("location", location);

        model.addAttribute("adsPage", adsPage);
        return "home";
    }

}
