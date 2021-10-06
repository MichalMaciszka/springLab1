package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionService {
    private ProfessionRepository repository;

    @Autowired
    public ProfessionService(ProfessionRepository repository){
        this.repository = repository;
    }

    public List<Profession> findAll(){
        return repository.findAll();
    }

    public void add(Profession profession){
        repository.add(profession);
    }
}
