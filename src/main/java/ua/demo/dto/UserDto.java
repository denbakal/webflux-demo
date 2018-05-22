package ua.demo.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
}
