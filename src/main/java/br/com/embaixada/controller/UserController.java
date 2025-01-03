package br.com.embaixada.controller;

import br.com.embaixada.model.PassPort;
import br.com.embaixada.model.PassportStatus;
import br.com.embaixada.model.Profile;
import br.com.embaixada.model.User;
import br.com.embaixada.repository.PassPortRepository;
import br.com.embaixada.repository.ProfileRepository;
import br.com.embaixada.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    PassPortRepository passportRepository;




    @GetMapping("/cadastro")
    public String getCadastro(Model model) {
        model.addAttribute("user", new User());
        return "/login/cadastro";
    }

    @PostMapping("/cadastro")
    public String getCadastro(@ModelAttribute @Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", user);
            return "/login/cadastro";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Profile profile = new Profile();
        profile.setNome(user.getUsername());
        user.setProfile(profile);
        PassPort passport = new PassPort();
        passport.setStatus(PassportStatus.BLOQUEADO);
        passport.setUser(user);
        profileRepository.save(profile);
        passportRepository.save(passport);
        userRepository.save(user);
        return "/login/login";
    }


    @GetMapping("/login")
    public String getLogin(Model model) {
        model.addAttribute("user", new User());
        return "/login/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);

        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser == null || !passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            model.addAttribute("error", "Nome de usuário ou senha inválidos. Tente novamente ou cadastre-se.");
            return "login/login";
        }
       return "redirect:/";
    }


}
