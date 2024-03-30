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
import pl.javastart.carzone.domain.ad.enums.BodyType;
import pl.javastart.carzone.domain.ad.enums.Brand;
import pl.javastart.carzone.domain.ad.enums.VehicleModel;

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
                @RequestParam(required = false) String bodyType){


        Page<AdDto> adsPage = adService.findAdsByCriteria(vehicleModel, vehicleBrand, bodyType,pageable);
        model.addAttribute("vehicleModel",vehicleModel);
        model.addAttribute("models", VehicleModel.values());

        model.addAttribute("vehicleBrand",vehicleBrand);
        model.addAttribute("brands", Brand.values());

        model.addAttribute("bodyType",bodyType);
        model.addAttribute("bodyTypes", BodyType.values());

        model.addAttribute("adsPage", adsPage);
        return "home";
    }

}
