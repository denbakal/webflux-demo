package ua.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.demo.dto.UserDto;

import java.util.Collections;
import java.util.List;

@RestController
public class UserController {
    @GetMapping(value = "users")
    public List<UserDto> getUsers() {
        return Collections.emptyList();
    }
}
