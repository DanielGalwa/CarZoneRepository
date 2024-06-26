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
import pl.javastart.carzone.domain.ad.enums.*;
import pl.javastart.carzone.domain.user.User;
import pl.javastart.carzone.domain.user.UserService;
import java.security.Principal;
@Controller
public class AdvertController {
    private final AdService adService;

    private final UserService userService;

    public AdvertController(AdService adService, UserService userService) {
        this.adService = adService;
        this.userService = userService;
    }

    @GetMapping("/ad/{id}")
    String getAdvert(@PathVariable long id, Model model) {
        AdDto ad = adService.findAdById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("ad", ad);
        return "advert";
    }
    @GetMapping("/my-account/ad-remove/{id}")
    public String removeAd(@PathVariable("id") long id) {
        adService.removeAdById(id);
        return "redirect:/my-account";
    }

    @GetMapping("/my-account/add-ad")
    public String addAdForm(Model model) {
        AdSaveDto ad = new AdSaveDto();
        model.addAttribute("ad", ad);
        model.addAttribute("brands",Brand.values());
        model.addAttribute("models", VehicleModel.values());
        model.addAttribute("bodyTypes", BodyType.values());
        model.addAttribute("fuelTypes", Fuel.values());
        model.addAttribute("gearboxTypes", Gearbox.values());
        model.addAttribute("sellerTypes",Seller.values());
        return "add-ad-form";
    }
    @PostMapping("/my-account/add-ad")
    public String addAd(AdSaveDto ad, Principal principal) {
        String username = principal.getName();
        if(userService.findByUsername(username).isEmpty()){
            return "redirect:/error/404";
        }
        User user = userService.findByUsername(username).get();
        adService.addAd(ad,user);
        return "redirect:/my-account";
    }
}
