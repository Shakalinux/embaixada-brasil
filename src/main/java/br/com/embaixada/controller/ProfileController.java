package br.com.embaixada.controller;

import br.com.embaixada.model.*;
import br.com.embaixada.repository.ProfileRepository;
import br.com.embaixada.repository.ServiceRepository;
import br.com.embaixada.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String viewProfile(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Usuário autenticado: " + authentication.getName());
        Profile profile = new Profile();
        String username = authentication.getName();
        User user = userRepository.findUserWithProfileAndMarksByEmail(username);

        if (user != null) {
            if (user.getProfile().getAvatar() != null) {
                String avatarBase64 = Base64.getEncoder().encodeToString(user.getProfile().getAvatar());
                user.getProfile().setAvatar64(avatarBase64);
            }
            model.addAttribute("profile", user.getProfile());
            model.addAttribute("marks", user.getMarks());
            model.addAttribute("user", user);
            PassPort passport = user.getPassport();
            if (passport != null) {
                model.addAttribute("passport", passport);
            }
        }

        return "profile/profile";
    }


    @PostMapping
    public String updateProfile(
            @RequestParam("nome") String nome,
            @RequestParam("cep") String cep,
            @RequestParam("logradouro") String logradouro,
            @RequestParam("estado") String estado,
            @RequestParam("cidade") String cidade,
            @RequestParam("telefone") String telefone,
            @RequestParam(value = "avatar", required = false) MultipartFile avatarFile,
            RedirectAttributes redirectAttributes) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Usuário autenticado: " + authentication.getName());
        String username = authentication.getName();
        User user = userRepository.findUserWithProfileAndMarksByEmail(username);
        if (user == null) {
            redirectAttributes.addFlashAttribute("error", "Usuário não encontrado.");
            return "redirect:/profile";
        }

        Profile profile = user.getProfile();

        profile.setNome(nome);
        profile.setCep(cep);
        profile.setLogradouro(logradouro);
        profile.setEstado(estado);
        profile.setUf(cidade);
        profile.setTelefone(telefone);

        if (avatarFile != null && !avatarFile.isEmpty()) {
            try {
                byte[] avatarBytes = avatarFile.getBytes();
                profile.setAvatar64(Base64.getEncoder().encodeToString(avatarBytes));
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("error", "Erro ao salvar o avatar.");
                return "redirect:/profile";
            }
        }

        profileRepository.save(profile);
        redirectAttributes.addFlashAttribute("success", "Perfil atualizado com sucesso.");
        return "redirect:/profile";
    }

}

