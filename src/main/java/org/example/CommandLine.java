package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;

@Component
public class CommandLine implements CommandLineRunner {
    private EmployeeService employeeService;
    private CompanyService companyService;

    @Autowired
    public CommandLine(EmployeeService es, CompanyService cs){
        employeeService = es;
        companyService = cs;
    }

    @Override
    public void run(String... args) throws Exception{
        // employeeService.findAll().forEach(System.out::println);
        boolean exit = false;
        Scanner in = new Scanner(System.in);
        while(!exit) {
            System.out.println("Give command (Type \"help\" for list of commands)");
            String command = in.nextLine();
            switch (command){
                case "help":
                    System.out.println("1. printCategories");
                    System.out.println("2. printElements");
                    System.out.println("3. add");
                    System.out.println("4. delete");
                    System.out.println("5. exit");
                    System.out.println();
                    break;
                case "printCategories":
                    companyService.findAll().forEach(System.out::println);
                    break;
                case "printElements":
                    employeeService.findAll().forEach(System.out::println);
                    break;
                case "add":
                    System.out.println("New employee");
                    System.out.print("ID: ");
                    //int id = in.nextInt();
                    int id = Integer.parseInt(in.nextLine());
                    System.out.print("First name: ");
                    String firstname = in.nextLine();
                    System.out.print("Last name: ");
                    String lastname = in.nextLine();
                    System.out.print("Salary: ");
                    double salary = Double.parseDouble(in.nextLine());
                    System.out.printf("Company name: ");
                    String companyName = in.nextLine();
                    Optional<Company> company = companyService.findByName(companyName);
                    if(company.isPresent()){
                        try {
                            employeeService.addEmployee(Employee.builder().id(id).firstname(firstname).lastname(lastname).salary(salary).company(company.get()).build());
                        } catch (IllegalArgumentException ex){
                            System.out.println(ex.getMessage());
                        }
                    }
                    else{
                        System.out.printf("Company not found \n");
                    }
                    break;
                case "delete":
                    System.out.printf("Give id number: ");
                    id = in.nextInt();
                    Optional<Employee> employee = employeeService.findById(id);
                    if(employee.isPresent()){
                        employeeService.delete(employee.get());
                    }
                    else{
                        System.out.println("Employee not found");
                    }
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    System.out.println("Wrong command");
                    break;
            }

        }
    }
}
