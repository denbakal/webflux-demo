package ua.demo.entity;

import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Entity
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
}
