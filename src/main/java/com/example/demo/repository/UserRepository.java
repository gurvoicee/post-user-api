package com.example.demo.repository;

import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserName(String userName);
}
