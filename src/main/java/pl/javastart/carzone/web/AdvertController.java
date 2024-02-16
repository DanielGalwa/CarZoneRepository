package pl.javastart.carzone.web;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import pl.javastart.carzone.domain.ad.AdvService;
import pl.javastart.carzone.domain.ad.dto.AdDto;

import java.util.Optional;

@Controller
public class AdvertController {
    private final AdvService advService;

    public AdvertController(AdvService advService) {
        this.advService = advService;
    }

    @GetMapping("/ad/{id}")
    String getAdvert(@PathVariable long id, Model model) {
        AdDto ad = advService.findAdById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("ad", ad);
        return "advert";
    }
}
