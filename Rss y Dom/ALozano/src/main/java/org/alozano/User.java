package org.alozano;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User { //CABIAR NOMBRE POR NOTICIAS
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
}
