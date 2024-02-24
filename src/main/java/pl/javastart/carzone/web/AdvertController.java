package pl.javastart.carzone.web;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;
import pl.javastart.carzone.domain.ad.AdService;
import pl.javastart.carzone.domain.ad.dto.AdDto;
import pl.javastart.carzone.domain.ad.dto.AdSaveDto;
import pl.javastart.carzone.domain.enums.Brand;
@Controller
public class AdvertController {
    private final AdService adService;

    public AdvertController(AdService adService) {
        this.adService = adService;
    }

    @GetMapping("/ad/{id}")
    String getAdvert(@PathVariable long id, Model model) {
        AdDto ad = adService.findAdById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("ad", ad);
        return "advert";
    }
    @GetMapping("/my-account/add-ad")
    public String addAdForm(Model model) {
        AdSaveDto ad = new AdSaveDto();
        model.addAttribute("ad", ad);
        model.addAttribute("brands",Brand.values());
        return "add-ad";
    }
    @PostMapping("/my-accountadd-ad")
    public String addAd(AdSaveDto ad) {
        adService.addAd(ad);
        return "redirect:/";
    }
}
