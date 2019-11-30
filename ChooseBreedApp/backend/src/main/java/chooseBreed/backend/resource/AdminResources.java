package chooseBreed.backend.resource;

import chooseBreed.backend.db.repositories.*;
import chooseBreed.backend.resource.util.Authenticate;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


@Controller
public class AdminResources {
    final BreedRepository breedRepository;
    final PhotoRepository photoRepository;
    final Environment environment;
    final BreedInfoRepository breedInfoRepository;

    public AdminResources(BreedRepository breedRepository, PhotoRepository photoRepository, Environment environment, BreedInfoRepository breedInfoRepository) {
        this.breedRepository = breedRepository;
        this.photoRepository = photoRepository;
        this.environment = environment;
        this.breedInfoRepository = breedInfoRepository;
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("pageTitle", "Logowanie");

        return "login";
    }

    @PostMapping("/auth")
    public String auth(Model model, @RequestParam("user") String user, @RequestParam("pass") String pass, HttpServletRequest request) {
        boolean isAdmin = false;
        if(user != null && pass != null && user.length() > 0 && pass.length() > 0)
            isAdmin = Authenticate.authenticate(user, pass, environment.getProperty("admin.login"), environment.getProperty("admin.password"));
        if(isAdmin){
            request.setAttribute("isAdmin", true);
        }

        model.addAttribute("pageTitle", "Wszystkie rasy");
        model.addAttribute("breedsInfos", breedInfoRepository.findAll());
        return "all";
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
