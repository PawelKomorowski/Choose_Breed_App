package chooseBreed.backend.resource;

import chooseBreed.backend.db.repositories.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


@Controller
public class AdminResources {
    final BreedRepository breedRepository;
    final PhotoRepository photoRepository;

    public AdminResources(BreedRepository breedRepository, PhotoRepository photoRepository) {
        this.breedRepository = breedRepository;
        this.photoRepository = photoRepository;
    }

    @GetMapping("/edit/{name}")
    public String editBreed(@PathVariable String name, Model model) {
        String url;
        try {
            url = URLDecoder.decode(name, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            url = name;
        }

        model.addAttribute("pageTitle", "Edycja: " + url);
        model.addAttribute("pageAction", "Edycja");
        model.addAttribute("breed", breedRepository.findByName(url).get(0));

        return "edit";
    }

    @GetMapping("/add")
    public String addBreed(Model model) {
        model.addAttribute("pageTitle", "Dodawanie");
        model.addAttribute("pageAction", "Dodawanie");

        return "edit";
    }

    @PostMapping("/save")
    public String saveBreed(Model model) {
        // TODO: Handle incoming values

        return "";
    }

}
