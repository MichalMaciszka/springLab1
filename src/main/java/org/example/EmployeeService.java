package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository){
        this.repository = repository;
    }

    public List<Employee> findAll(){
        return repository.findAll();
    }

    public void addEmployee(Employee employee) throws IllegalArgumentException{
        repository.add(employee);
    }

    public Optional<Employee> findById(int id){
        return repository.findById(id);
    }

    public void delete(Employee employee){
        repository.delete(employee);
    }
}
