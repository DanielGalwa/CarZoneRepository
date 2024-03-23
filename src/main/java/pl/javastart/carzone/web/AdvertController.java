package pl.javastart.carzone.web;
import org.springframework.data.domain.Page;
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
import pl.javastart.carzone.domain.ad.enums.Brand;
import pl.javastart.carzone.domain.user.User;
import pl.javastart.carzone.domain.user.UserService;
import pl.javastart.carzone.domain.user.dto.UserCredentialsDto;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class AdvertController {
    private final AdService adService;
    private final UserService userService;

    public AdvertController(AdService adService,UserService userService) {
        this.userService = userService;
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
    @GetMapping("/my-account")
    public String myAccount(Model model, Principal principal) {
        String username = principal.getName();
        Optional<UserCredentialsDto> user = userService.findCredentialsByEmail(username);
        String email = user.get().getEmail();
        List<AdDto> adsForCurrentUser = adService.findAdsByUserEmail(email);
        model.addAttribute("ads", adsForCurrentUser);
        return "my-account";
    }
    @PostMapping("/my-account/add-ad")
    public String addAd(AdSaveDto ad) {
        adService.addAd(ad);
        return "redirect:/my-account";
    }
}
