package br.com.embaixada.controller;

import br.com.embaixada.model.Mark;
import br.com.embaixada.model.Service;
import br.com.embaixada.model.User;
import br.com.embaixada.repository.MarkRepository;
import br.com.embaixada.repository.ServiceRepository;
import br.com.embaixada.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private MarkRepository markRepository;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/{id}")
    public String getServiceDetails(@PathVariable Long id, Model model, Principal principal) {
        Service service = serviceRepository.findById(id).orElse(null);
        User user = userRepository.findByEmail(principal.getName());

        if (service == null) {
            return "error/404";
        }
        if (service.getImagem() != null) {
            String imagemBase64 = Base64.getEncoder().encodeToString(service.getImagem());
            service.setTaskImage64(imagemBase64);
        }

        model.addAttribute("service", service);
        model.addAttribute("mark", new Mark());
        model.addAttribute("user", user);

        return "service/details";
    }


    @PostMapping("/agendar/{id}")
    public String agendarServico(@PathVariable Long id,
                                 @ModelAttribute @Valid Mark mark,
                                 BindingResult bindingResult,
                                 Principal principal,
                                 Model model) {
        Service service = serviceRepository.findById(id).orElse(null);

        if (service == null) {
            model.addAttribute("error", "Serviço não encontrado.");
            return "error/404";
        }

        if (bindingResult.hasErrors()) {
            if (service.getImagem() != null) {
                String imagemBase64 = Base64.getEncoder().encodeToString(service.getImagem());
                service.setTaskImage64(imagemBase64);
            }
            model.addAttribute("service", service);
            return "service/details";
        }

        if (principal == null) {
            return "redirect:/user/login";
        }

        User user = userRepository.findByEmail(principal.getName());

        if (user == null) {
            model.addAttribute("error", "Usuário não encontrado.");
            return "redirect:/user/login";
        }
        mark.setService(service);
        mark.setUser(user);
        markRepository.save(mark);
        serviceRepository.save(service);
        return "redirect:/";
    }






}


