package org.example;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
public class Profession implements Serializable {
    String name;
    double moveSpeed;
    int baseArmor;
}
