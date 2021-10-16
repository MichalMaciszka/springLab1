package org.example;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class CompanyRepository {
    private Storage storage;

    @Autowired
    public CompanyRepository(Storage storage){
        this.storage = storage;
    }

    public List<Company> findAll(){
        return storage.findAllCompanies();
    }

    public void add(Company company) throws IllegalArgumentException{
        storage.addCompany(company);
    }

    public void delete(Company company) {
        storage.deleteCompany(company);
    }

    public Optional<Company> findByName(String name){
        return storage.findCompanyByName(name);
    }

}
