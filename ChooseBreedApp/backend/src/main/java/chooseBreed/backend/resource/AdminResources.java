package chooseBreed.backend.resource;

import chooseBreed.backend.db.model.Breed;
import chooseBreed.backend.db.repositories.*;
import chooseBreed.backend.resource.util.Authenticate;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


@Controller
public class AdminResources {
    final BreedRepository breedRepository;
    final PhotoRepository photoRepository;
    final Environment environment;
    final BreedInfoRepository breedInfoRepository;
    final BreedGroupRepository breedGroupRepository;

    public AdminResources(BreedRepository breedRepository, PhotoRepository photoRepository, Environment environment, BreedInfoRepository breedInfoRepository, BreedGroupRepository breedGroupRepository) {
        this.breedRepository = breedRepository;
        this.photoRepository = photoRepository;
        this.environment = environment;
        this.breedInfoRepository = breedInfoRepository;
        this.breedGroupRepository = breedGroupRepository;
    }

    @GetMapping("/login")
    public String login(Model model, @RequestParam(required = false) String status, HttpSession session) {
        // Redirect to home if user already logged in
        if (session.getAttribute("isAdmin") != null && (boolean) session.getAttribute("isAdmin")) {
            return "redirect:/";
        }

        if (status != null) {
            model.addAttribute("status", status);
        }

        model.addAttribute("pageTitle", "Logowanie");

        return "login";
    }

    @PostMapping("/auth")
    public String auth(Model model, @RequestParam("user") String user, @RequestParam("pass") String pass, HttpSession session) {
        boolean isAdmin = false;
        if(user != null && pass != null && user.length() > 0 && pass.length() > 0) {
            isAdmin = Authenticate.authenticate(user, pass, environment.getProperty("admin.login"), environment.getProperty("admin.password"));

            if (isAdmin) {
                session.setAttribute("isAdmin", true);
                return "redirect:/all";
            }
        }

        return "redirect:/login?status=err";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        if(session.getAttribute("isAdmin") != null && (Boolean)session.getAttribute("isAdmin")) {
            session.setAttribute("isAdmin", null);

            return "redirect:/";
        }
        return "redirect:/all";
    }

    @GetMapping("/edit/{name}")
    public String editBreed(@PathVariable String name, Model model, HttpSession session) {
        if(session.getAttribute("isAdmin") != null && (Boolean)session.getAttribute("isAdmin")) {
            String url;
            try {
                url = URLDecoder.decode(name, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                url = name;
            }

            model.addAttribute("pageTitle", "Edycja: " + url);
            model.addAttribute("pageAction", "Edycja");
            model.addAttribute("breed", breedRepository.findByName(url).get(0));
            model.addAttribute("groups", breedGroupRepository.findAll());

            return "edit";
        }
        return "redirect:/all";
    }

    @GetMapping("/add")
    public String addBreed(Model model, HttpSession session) {
        if(session.getAttribute("isAdmin") != null && (Boolean)session.getAttribute("isAdmin")) {
            model.addAttribute("pageTitle", "Dodawanie");
            model.addAttribute("pageAction", "Dodawanie");
            model.addAttribute("groups", breedGroupRepository.findAll());

            return "edit";
        }
        return "redirect:/all";
    }

    @PostMapping("/save")
    public String saveBreed(Model model, @ModelAttribute Breed breed, HttpSession session) {
        if(session.getAttribute("isAdmin") != null && (Boolean)session.getAttribute("isAdmin")) {
            breedRepository.save(breed);
        }
        return "redirect:/all";
    }

}
