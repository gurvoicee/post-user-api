package com.example.demo.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="tbl_user")
@Data
@NoArgsConstructor
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String userName;
    String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
