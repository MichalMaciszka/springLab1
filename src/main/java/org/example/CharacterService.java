package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {
    private CharacterRepository repository;

    @Autowired
    public CharacterService(CharacterRepository repository){
        this.repository = repository;
    }

    public List<Character> findAll(){
        return repository.findAll();
    }

    public void addCharacter(Character character){
        repository.add(character);
    }

    public void delete(Character character){
        repository.delete(character);
    }

    public void delete(String name){
        repository.delete(name);
    }
}
