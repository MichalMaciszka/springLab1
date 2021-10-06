package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLine implements CommandLineRunner {
    private CharacterService characterService;
    private ProfessionService professionService;

    @Autowired
    public CommandLine(CharacterService cs, ProfessionService ps){
        characterService = cs;
        professionService = ps;
    }

    @Override
    public void run(String... args) throws Exception{
        characterService.findAll().forEach(System.out::println);
    }
}
