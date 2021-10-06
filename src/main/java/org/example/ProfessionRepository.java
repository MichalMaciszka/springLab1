package org.example;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Repository
public class ProfessionRepository {
    private Storage storage;

    @Autowired
    public ProfessionRepository(Storage storage){
        this.storage = storage;
    }

    public List<Profession> findAll(){
        return storage.findAllProfessions();
    }

    public void add(Profession profession){
        storage.addProfession(profession);
    }

}
