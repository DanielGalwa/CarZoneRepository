package pl.javastart.carzone.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.javastart.carzone.domain.ad.dto.AdDto;
import pl.javastart.carzone.domain.ad.AdService;

import java.util.List;

@Controller
public class HomeController {
    private final AdService adService;

    public HomeController(AdService adService) {
        this.adService = adService;
    }

    @GetMapping("/")
    String home(Model model) {
        List<AdDto> adsList = adService.findAllAds();
        model.addAttribute("list", adsList);
        return "home";
    }
}
