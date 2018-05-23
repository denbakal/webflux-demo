package ua.demo.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.demo.entity.User;
import ua.demo.repository.UserRepository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private JPAQueryFactory queryFactory;

    @Override
    public List<User> findAll() {
        return null;
//        return queryFactory.selectFrom();
    }
}
