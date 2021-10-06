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
public class Character implements Serializable {
    String name;
    Profession profession;
    int level;
}
