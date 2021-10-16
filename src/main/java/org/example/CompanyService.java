package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    private CompanyRepository repository;

    @Autowired
    public CompanyService(CompanyRepository repository){
        this.repository = repository;
    }

    public List<Company> findAll(){
        return repository.findAll();
    }

    public void add(Company company) throws IllegalArgumentException{
        repository.add(company);
    }

    public Optional<Company> findByName(String name) {
        return repository.findByName(name);
    }
}
