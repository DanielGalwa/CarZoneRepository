package pl.javastart.carzone.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.javastart.carzone.domain.ad.AdService;
import pl.javastart.carzone.domain.ad.dto.AdDto;
import pl.javastart.carzone.domain.user.User;
import pl.javastart.carzone.domain.user.UserService;
import pl.javastart.carzone.domain.user.dto.UserCredentialsDto;
import pl.javastart.carzone.domain.user.dto.UserRegistrationDto;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class AccountController {

    private final AdService adService;
    private final UserService userService;

    public AccountController(AdService adService, UserService userService) {
        this.adService = adService;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login-form";
    }
    @GetMapping("/my-account")
    public String myAccount(Model model, Principal principal) {
        String username = principal.getName();
        Optional<UserCredentialsDto> user = userService.findCredentialsByEmail(username);
        if(user.isEmpty()){
            return "redirect:/error/404";
        }
        String email = user.get().getEmail();
        List<AdDto> adsForCurrentUser = adService.findAdsByUserEmail(email);
        model.addAttribute("ads", adsForCurrentUser);
        return "my-account";
    }
    @GetMapping("/registration")
    public String registrationForm(Model model) {
        UserRegistrationDto userRegistration = new UserRegistrationDto();
        model.addAttribute("user", userRegistration);
        return "registration-form";
    }

    @PostMapping("/registration")
    public String register(UserRegistrationDto userRegistration) {
        userService.registerUserWithDefaultRole(userRegistration);
        return "redirect:/";
    }

}
