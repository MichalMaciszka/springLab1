package org.example;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.stream.Collectors;

@Log
@Component
public class Storage{
    private Set<Character> characters = new HashSet<>();
    private Set<Profession> professions = new HashSet<>();

    public synchronized List<Profession> findAllProfessions() {
        return new ArrayList<>(professions);
    }

    public synchronized List<Character> findAllCharacters(){
        return characters.stream()
                .map(Cloning::clone)
                .collect(Collectors.toList());
    }

    public Optional<Character> findCharacterByName(String name){
        return characters.stream()
                .filter(c -> c.getName().equals(name))
                .findFirst()
                .map(Cloning::clone);
    }

    public void createCharacter(Character character){
        characters.add(Cloning.clone(character));
    }

    public void deleteCharacter(String name){
        Optional<Character> character = findCharacterByName(name);
        if(character.isEmpty()) return;
        Character characterFromSet = characters.stream().filter(c -> c.getName().equals(character.get().getName())).findFirst().get();
        characters.remove(characterFromSet);
    }

    public void addProfession(Profession profession){
        professions.add(profession);
    }

}
