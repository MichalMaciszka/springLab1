package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInit {
    private final CharacterService characterService;
    private final ProfessionService professionService;

    @Autowired
    public DataInit(CharacterService cs, ProfessionService ps){
        characterService = cs;
        professionService = ps;
    }

    @PostConstruct
    private synchronized void init(){
        Profession mage = Profession.builder()
                .baseArmor(3)
                .name("Mage")
                .moveSpeed(5)
                .build();
        Profession knight = Profession.builder()
                .baseArmor(7)
                .name("Knight")
                .moveSpeed(2)
                .build();
        Profession healer = Profession.builder()
                .baseArmor(1)
                .moveSpeed(4)
                .name("Healer")
                .build();

        professionService.add(mage);
        professionService.add(knight);
        professionService.add(healer);

        Character calvian = Character.builder()
                .name("Calvian")
                .level(3)
                .profession(mage)
                .build();
        Character uhlbert = Character.builder()
                .name("Ulhbert")
                .level(2)
                .profession(mage)
                .build();
        Character eloise = Character.builder()
                .level(4)
                .name("Eloise")
                .profession(knight)
                .build();
        Character zereni = Character.builder()
                .level(1)
                .name("Zereni")
                .profession(knight)
                .build();
        Character chef = Character.builder()
                .level(7)
                .name("Chef")
                .profession(healer)
                .build();

        characterService.addCharacter(calvian);
        characterService.addCharacter(uhlbert);
        characterService.addCharacter(eloise);
        characterService.addCharacter(zereni);
        characterService.addCharacter(chef);

    }

}
