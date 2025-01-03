package br.com.embaixada.controller;

import br.com.embaixada.model.Service;
import br.com.embaixada.model.User;
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

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping("/")
public class GlobalController {

    @Autowired
    private ServiceRepository serviceRepository;

    @GetMapping
    public String getHome(Model model) {
        List<Service> services = (List<Service>) serviceRepository.findAll();
        model.addAttribute("services", services);


        for (Service service : services) {
            if (service.getImagem() != null) {
                String imagemBase64 = Base64.getEncoder().encodeToString(service.getImagem());
                service.setTaskImage64(imagemBase64);

            }
        }
        return "home";
    }

    @GetMapping("/service/new")
    public String newServicePage() {
        return "new-service";
    }

    @PostMapping("/service/new")
    public String saveService(@RequestParam("service") String serviceName,
                              @RequestParam("description") String description,
                              @RequestParam("imagem") MultipartFile imagem, Model model) throws IOException {
        byte[] imageBytes = imagem.getBytes();
        Service service = new Service();
        service.setService(serviceName);
        service.setDescription(description);
        service.setImagem(imageBytes);
        serviceRepository.save(service);
        return "redirect:/service/new";
    }


    @GetMapping("/contato")
    public String getContatoPage() {
        return "contato/contato";
    }

    @GetMapping("/saiba")
    public String getSaibaPage() {
        return "saiba/saiba";
    }
}
