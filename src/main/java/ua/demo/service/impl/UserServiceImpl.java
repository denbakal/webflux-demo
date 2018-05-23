package ua.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.demo.dto.UserDto;
import ua.demo.mapper.UserMapper;
import ua.demo.service.UserService;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDto> getUsers() {
        return userMapper.fromUserList(Collections.emptyList());
    }
}
