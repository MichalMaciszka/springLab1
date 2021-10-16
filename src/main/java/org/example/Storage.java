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
    private Set<Employee> employees = new HashSet<>();
    private Set<Company> companies = new HashSet<>();

    public synchronized List<Company> findAllCompanies() {
        return new ArrayList<>(companies);
    }

    public synchronized List<Employee> findAllEmployees(){
        return employees.stream()
                .map(Cloning::clone)
                .collect(Collectors.toList());
    }

    public Optional<Employee> findEmployeeByLastname(String lastname){
        return employees.stream()
                .filter(c -> c.getLastname().equals(lastname))
                .findFirst()
                .map(Cloning::clone);
    }

    public void createEmployee(Employee employee) throws IllegalArgumentException{
        if(findEmployeeById(employee.getId()).isPresent()){
            throw new IllegalArgumentException("Id taken");
        }
        employees.add(Cloning.clone(employee));
    }

    public void deleteEmployee(Employee employee){
        Optional<Employee> opt = findEmployeeById(employee.getId());
        if(opt.isEmpty()) return;
        Employee fromSet = employees.stream().filter(e -> e.getId() == employee.getId()).findFirst().get();
        employees.remove(fromSet);
    }

    public void addCompany(Company company){
        if(findCompanyByName(company.getName()).isPresent()){
            throw new IllegalArgumentException("Name taken");
        }
        companies.add(company);
    }

    public Optional<Employee> findEmployeeById(int id){
        return employees.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .map(Cloning::clone);
    }

    public Optional<Company> findCompanyByName(String name){
        return companies.stream()
                .filter(c -> c.getName().equals(name))
                .findFirst()
                .map(Cloning::clone);
    }

    public void deleteCompany(Company company){
        Optional<Company> opt = findCompanyByName(company.getName());
        if(opt.isEmpty()) return;
        Company fromSet = companies.stream().filter(c -> c.getName().equals(company.getName())).findFirst().get();
        companies.remove(fromSet);
    }

}
