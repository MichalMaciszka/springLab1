package org.example;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository

public class EmployeeRepository {
    private Storage storage;

    @Autowired
    public EmployeeRepository(Storage storage){
        this.storage = storage;
    }

    public List<Employee> findAll(){
        return storage.findAllEmployees();
    }

    public void add(Employee employee) throws IllegalArgumentException{
        storage.createEmployee(employee);
    }

    public void delete(Employee employee){
        storage.deleteEmployee(employee);
    }

    public Optional<Employee> findById(int id){
        return storage.findEmployeeById(id);
    }
}
