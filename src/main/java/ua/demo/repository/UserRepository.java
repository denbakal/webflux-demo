package ua.demo.repository;

import ua.demo.entity.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
}
