package org.example;


import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Employee implements Serializable {
    int id;
    String firstname;
    String lastname;
    double salary;
    Company company;
}
