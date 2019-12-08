package chooseBreed.backend.resource;

import chooseBreed.backend.db.model.Breed;
import chooseBreed.backend.db.model.Photo;
import chooseBreed.backend.db.repositories.*;
import chooseBreed.backend.resource.util.Authenticate;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@Controller
public class AdminResources {
    private static String saveImageDirectory = System.getProperty("user.dir") + "\\backend\\src\\main\\resources\\static\\images";
    private static String showImageDirectory = "/images/";
    final ServletContext context;

    final BreedRepository breedRepository;
    final PhotoRepository photoRepository;
    final Environment environment;
    final BreedInfoRepository breedInfoRepository;
    final BreedGroupRepository breedGroupRepository;

    public AdminResources(BreedRepository breedRepository, PhotoRepository photoRepository, Environment environment, BreedInfoRepository breedInfoRepository, BreedGroupRepository breedGroupRepository, ServletContext context) {
        this.breedRepository = breedRepository;
        this.photoRepository = photoRepository;
        this.environment = environment;
        this.breedInfoRepository = breedInfoRepository;
        this.breedGroupRepository = breedGroupRepository;
        this.context = context;
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
            Breed breed = breedRepository.findByName(url).get(0);
            model.addAttribute("breed", breed);
            model.addAttribute("photos", photoRepository.findByBreed(breed));
            model.addAttribute("groups", breedGroupRepository.findAll());
            model.addAttribute("path", showImageDirectory);

            return "edit";
        }
        return "redirect:/all";
    }

    @GetMapping("/add")
    public String addBreed(Model model, HttpSession session) {
        if(session.getAttribute("isAdmin") != null && (Boolean)session.getAttribute("isAdmin")) {
            model.addAttribute("pageTitle", "Dodawanie");
            model.addAttribute("pageAction", "Dodawanie");
            model.addAttribute("photos", new ArrayList<Photo>());
            model.addAttribute("groups", breedGroupRepository.findAll());

            return "edit";
        }
        return "redirect:/all";
    }

    //TODO post?
    @GetMapping("/delete/{name}")
    public String deleteBreed(Model model, @PathVariable String name, HttpSession session) {
        if(session.getAttribute("isAdmin") != null && (Boolean)session.getAttribute("isAdmin")) {
            String url;
            try {
                url = URLDecoder.decode(name, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                url = name;
            }
            breedRepository.deleteAll(breedRepository.findByName(url));
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

    //TODO ogarnąć ścieżki do plików
    @PostMapping("/savephoto/{name}")
    public String savePhotos(@RequestParam("image") List<MultipartFile> images, @PathVariable String name, HttpSession session) {
        if(session.getAttribute("isAdmin") != null && (Boolean)session.getAttribute("isAdmin")) {
            String url;
            try {
                url = URLDecoder.decode(name, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                url = name;
            }
            List<Breed> breeds = breedRepository.findByName(url);
            if (breeds.size() != 1)
                return "redirect:/";

            Photo photo = new Photo();
            for (MultipartFile f : images) {
                try {
                    Path filePath = Paths.get(saveImageDirectory, f.getOriginalFilename());
                    Files.write(filePath, f.getBytes());

                    photo.setBreed(breeds.get(0));
                    photo.setFile(f.getOriginalFilename());
                    photoRepository.save(photo);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return "redirect:/edit/" + breeds.get(0).urlEncode();
        }
        return "redirect:/all";
    }

    @GetMapping("/delphoto/{id}")
    public String deletePhotos(@PathVariable int id, HttpSession session) {
        if(session.getAttribute("isAdmin") != null && (Boolean)session.getAttribute("isAdmin")) {
            List<Photo> photos = photoRepository.findById(id);
            if (photos.size() != 1)
                return "redirect:/";
            try {
                Files.delete(Paths.get(saveImageDirectory, photos.get(0).getFile()));
                photoRepository.deleteAll(photoRepository.findById(id));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "redirect:/edit/" + photos.get(0).getBreed().urlEncode();
        }
        return "redirect:/all";
    }
}
