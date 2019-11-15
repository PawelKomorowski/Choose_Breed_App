package chooseBreed.backend.CommandLineRunner;

import chooseBreed.backend.db.model.*;
import chooseBreed.backend.db.model.enums.*;
import chooseBreed.backend.db.model.view.BreedsInfo;
import chooseBreed.backend.db.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class runner implements CommandLineRunner {
    private final BreedGroupRepository breedGroupRepository;
    private final BreedRepository breedRepository;
    private final IllnessRepository illnessRepository;
    private final PhotoRepository photoRepository;
    private final BreedInfoRepository breedInfoRepository;

    public runner(BreedGroupRepository breedGroupRepository, BreedRepository breedRepository, IllnessRepository illnessRepository, PhotoRepository photoRepository, BreedInfoRepository breedInfoRepository) {
        this.breedGroupRepository = breedGroupRepository;
        this.breedRepository = breedRepository;
        this.illnessRepository = illnessRepository;
        this.photoRepository = photoRepository;
        this.breedInfoRepository = breedInfoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        /*
         * Notatki:
         * Przy relacji 1:N wystarczy dać obiekt po stronie 1 np breed i photo -> setObiekt zamiast dodawać go do listy [1]
         * Przy trelacji N:M wystarczzy dodać do listy po jednej ze stron np breed i illenss [2]
         */
        //Add groups
        BreedGroup breedGroup1 = new BreedGroup();
        BreedGroup breedGroup2 = new BreedGroup();
        breedGroup1.setName("pasterskie_i_owczarki");
        breedGroup2.setName("pinczery_sznaucery_molosy");
        breedGroupRepository.save(breedGroup1);
        breedGroupRepository.save(breedGroup2);

        //Add illnesses
        Illness illness1 = new Illness();
        Illness illness2 = new Illness();
        illness1.setName("Illness1");
        illness2.setName("Illness2");
        illnessRepository.save(illness1);
        illnessRepository.save(illness2);

        //Add breeds
        Breed breed1 = new Breed();
        Breed breed2 = new Breed();
        breed1.setName("border");
        breed1.setBreedGroup(breedGroup1);
        breed1.setCleaningDifficulty(CleaningDifficulty.SREDNIO);
        breed1.setCost((short) 2500);
        breed1.setDescription("pies1");
        breed1.setHairLength(HairLength.SREDNIA);
        breed1.setHairType(HairType.PUCHATA);
        breed1.setWeight((short) 25);
        breed1.setLiveLength((short) 15);
        breed1.setLivelihoodCost((short) 130);
        breed1.setTrainDifficulty(TrainDifficulty.LATWO);
        breed1.setSize(Size.SREDNI);
        //[2]
        breed1.getIllnesses().add(illness1);

        breed2.setName("corgi");
        breed2.setBreedGroup(breedGroup1);
        breed2.setCleaningDifficulty(CleaningDifficulty.LATWO);
        breed2.setCost((short) 5000);
        breed2.setDescription("pies2");
        breed2.setHairLength(HairLength.SREDNIA);
        breed2.setHairType(HairType.GLADKA);
        breed2.setWeight((short) 15);
        breed2.setLiveLength((short) 14);
        breed2.setLivelihoodCost((short) 150);
        breed2.setTrainDifficulty(TrainDifficulty.TRUDNO);
        breed2.setSize(Size.MALY);
        breedRepository.save(breed1);
        breedRepository.save(breed2);

        //Add photos
        Photo photo1 = new Photo();
        Photo photo2 = new Photo();
        photo1.setFile("photo1");
        photo2.setFile("photo2");
        //[1]
        photo1.setBreed(breed1);
        photo2.setBreed(breed2);
        photoRepository.save(photo1);
        photoRepository.save(photo2);

        List<BreedsInfo> breedsInfos = breedInfoRepository.findAll();
        for(BreedsInfo b : breedsInfos)
            System.out.println(b.toString());
    }
}
