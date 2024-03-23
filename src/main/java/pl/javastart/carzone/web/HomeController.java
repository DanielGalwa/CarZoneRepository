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

@Controller
public class HomeController {
    private final AdService adService;

    public HomeController(AdService adService) {
        this.adService = adService;
    }

    @GetMapping("/")
    String home(Model model, @PageableDefault(size = 5) Pageable pageable,
                @RequestParam(required = false) String vehicleModel,
                @RequestParam(required = false) String vehicleBrand) {

        //Page<AdDto> adsPage = adService.findAllAds(pageable);
        Page<AdDto> adsPage = adService.findAdsByCriteria(vehicleModel, vehicleBrand,pageable);
        model.addAttribute("vehicleModel",vehicleModel);
        model.addAttribute("vehicleBrand",vehicleBrand);
        model.addAttribute("adsPage", adsPage);
        return "home";
    }

}
