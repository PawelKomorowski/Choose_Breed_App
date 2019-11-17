package chooseBreed.backend.resource;

import chooseBreed.backend.db.repositories.BreedInfoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


@Controller
public class MainResources {
    final BreedInfoRepository breedInfoRepository;

    public MainResources(BreedInfoRepository breedInfoRepository) {
        this.breedInfoRepository = breedInfoRepository;
    }

    @GetMapping("/style")
    public String style(){
        return "style";
    }

    @GetMapping("/all")
    public String allBreeds(Model model){
        model.addAttribute("breedsInfos", breedInfoRepository.findAll());

        return "all";
    }

    @GetMapping("/breed/{name}")
    public String showAllBreeds(@PathVariable String name, Model model){
        String url;
        try {
            url = URLDecoder.decode(name, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            url = name;
        }
        model.addAttribute("breed", breedInfoRepository.findByName(url).get(0));

        return "breed";
    }

    @GetMapping("/")
    public String search(){
        return "search";
    }

    //ReqiestParam("?")
    @GetMapping("/result")
    public String result(){
        return "search";
    }
}
