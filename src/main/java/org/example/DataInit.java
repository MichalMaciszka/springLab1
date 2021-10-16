package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInit {
    private final EmployeeService employeeService;
    private final CompanyService companyService;

    @Autowired
    public DataInit(EmployeeService es, CompanyService cs){
        employeeService = es;
        companyService = cs;
    }

    @PostConstruct
    private synchronized void init(){
        /*Profession mage = Profession.builder()
                .baseArmor(3)
                .name("Mage")
                .moveSpeed(5)
                .build();
        Profession knight = Profession.builder()
                .baseArmor(7)
                .name("Knight")
                .moveSpeed(2)
                .build();
        Profession healer = Profession.builder()
                .baseArmor(1)
                .moveSpeed(4)
                .name("Healer")
                .build();

        professionService.add(mage);
        professionService.add(knight);
        professionService.add(healer);

        Character calvian = Character.builder()
                .name("Calvian")
                .level(3)
                .profession(mage)
                .build();
        Character uhlbert = Character.builder()
                .name("Ulhbert")
                .level(2)
                .profession(mage)
                .build();
        Character eloise = Character.builder()
                .level(4)
                .name("Eloise")
                .profession(knight)
                .build();
        Character zereni = Character.builder()
                .level(1)
                .name("Zereni")
                .profession(knight)
                .build();
        Character chef = Character.builder()
                .level(7)
                .name("Chef")
                .profession(healer)
                .build();

        characterService.addCharacter(calvian);
        characterService.addCharacter(uhlbert);
        characterService.addCharacter(eloise);
        characterService.addCharacter(zereni);
        characterService.addCharacter(chef);*/

        Company comp1 = Company.builder()
                .name("comp1")
                .budget(13034.32)
                .build();
        Company comp2 = Company.builder()
                .name("comp2")
                .budget(78645.43)
                .build();
        companyService.add(comp1);
        companyService.add(comp2);

        Employee e1 = Employee.builder()
                .id(1)
                .firstname("C")
                .lastname("E1")
                .salary(5279.22)
                .company(comp1)
                .build();
        Employee e2 = Employee.builder()
                .id(2)
                .firstname("B")
                .lastname("E2")
                .salary(3458.54)
                .company(comp1)
                .build();
        Employee e3 = Employee.builder()
                .id(3)
                .firstname("A")
                .lastname("E3")
                .salary(1586.45)
                .company(comp2)
                .build();

        employeeService.addEmployee(e1);
        employeeService.addEmployee(e2);
        employeeService.addEmployee(e3);

    }

}
