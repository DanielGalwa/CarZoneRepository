package pl.javastart.carzone.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class AdvertController {

    @GetMapping("/test")
    String advert(Model model) {
        return "advertv2";
    }
}
