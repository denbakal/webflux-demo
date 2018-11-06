package ua.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.demo.dto.UserDto;

@RestController
public class UserController {
    @GetMapping(value = "users")
    public String getUsers() {
        UserDto userDto = new UserDto();
        return "test";
    }
}
