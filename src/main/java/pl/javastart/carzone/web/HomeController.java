package pl.javastart.carzone.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.javastart.carzone.domain.ad.dto.AdDto;
import pl.javastart.carzone.domain.ad.AdvService;

import java.util.List;

@Controller
public class HomeController {
    private final AdvService advService;

    public HomeController(AdvService advService) {
        this.advService = advService;
    }

    @GetMapping("/")
    String home(Model model) {
        List<AdDto> adsList = advService.findAllAds();
        model.addAttribute("list", adsList);
        return "home";
    }
}
