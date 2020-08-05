package com.example.Thymeleaf.repository;

import com.example.Thymeleaf.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThymeleafRepo extends CrudRepository<User, Integer> {
    User findByName(String name);
}
