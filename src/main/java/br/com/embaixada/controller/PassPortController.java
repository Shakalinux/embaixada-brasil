package br.com.embaixada.controller;

import br.com.embaixada.model.PassPort;
import br.com.embaixada.model.PassportStatus;
import br.com.embaixada.model.User;
import br.com.embaixada.repository.PassPortRepository;
import br.com.embaixada.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/passport")
public class PassPortController {

    @Autowired
    private PassPortRepository passportRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public String getPassport(@PathVariable Long id, Model model) {
        System.out.printf("getPassport: %d\n", id);
        User user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return "error/404";
        }

        PassPort passport = user.getPassport();
        if (passport == null) {
            passport = new PassPort(user, PassportStatus.BLOQUEADO);
            passportRepository.save(passport);
        }
        model.addAttribute("passport", passport);
        model.addAttribute("user", user);
        return "service/validacao";
    }

    @PostMapping("/{id}")
    public String toggleStatus(@PathVariable Long id) {
        PassPort passport = passportRepository.findById(id).orElse(null);
        if (passport != null) {
            if (passport.getStatus() == PassportStatus.BLOQUEADO) {
                passport.setStatus(PassportStatus.ATIVO);
            } else {
                passport.setStatus(PassportStatus.BLOQUEADO);
            }
            passportRepository.save(passport);
        }
        return "redirect:/profile";
    }
}
