package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="tbl_user")
@Data
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String password;

}
