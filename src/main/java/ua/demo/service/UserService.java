package ua.demo.service;

import ua.demo.dto.UserDto;

import java.util.List;

public interface UserService {
    public List<UserDto> getUsers();
}
