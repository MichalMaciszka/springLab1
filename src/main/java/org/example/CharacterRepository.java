package org.example;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Repository

public class CharacterRepository {
    private Storage storage;

    @Autowired
    public CharacterRepository(Storage storage){
        this.storage = storage;
    }

    public List<Character> findAll(){
        return storage.findAllCharacters();
    }

    public void add(Character character){
        storage.createCharacter(character);
    }

    public void delete(Character character){
        storage.deleteCharacter(character.getName());
    }

    public void delete(String name){
        storage.deleteCharacter(name);
    }
}
